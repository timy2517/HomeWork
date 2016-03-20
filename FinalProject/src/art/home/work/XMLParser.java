package art.home.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser {

	

	// метод возвращает root с данными из xml
	public Root parsing()
			throws ParserConfigurationException, SAXException, IOException {

		List<String> emailsList = new ArrayList<String>();
		List<Goods> goodsList = new ArrayList<Goods>();
		Root root = new Root();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		File file = new File("shop.xml");
		InputStream inputStream = new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");

		DefaultHandler handler = new DefaultHandler() {
			Goods goods = new Goods();

			boolean isIdTag = false;
			boolean isShopNameTag = false;
			boolean isGoodsNameTag = false;
			boolean isDescriptionTag = false;
			boolean isYearTag = false;
			boolean isPriceTag = false;
			boolean isVisibleTag = false;
			boolean isLocationTag = false;
			boolean isEmailsTag = false;
			boolean isGoodsTag = false;

			boolean nameFlag = false; // когда true - заполняется goods
			boolean successfulFlag = false; // если возникла ошибка заполнения
											// полей
											// - элемент не добавляется

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName.equals("name") && !nameFlag) {
					isShopNameTag = true;
					nameFlag = true;
				} else if (qName.equals("name") && nameFlag) {
					this.goods = new Goods();
					isGoodsNameTag = true;
				} else {
					isIdTag = "id".equals(qName);
					isDescriptionTag = "description".equals(qName);
					isYearTag = "year".equals(qName);
					isPriceTag = "price".equals(qName);
					isVisibleTag = "visible".equals(qName);
					isLocationTag = "location".equals(qName);
					isEmailsTag = "emails".equals(qName);
					isGoodsTag = "goods".equals(qName);
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				try {
					if (isIdTag) {
						goods.setId(Integer.parseInt(String.copyValueOf(ch, start, length)));
						isIdTag = false;
					} else if (isShopNameTag) {
						root.setName(String.copyValueOf(ch, start, length));
						isShopNameTag = false;
					} else if (isGoodsNameTag) {
						goods.setName(String.copyValueOf(ch, start, length));
						isGoodsNameTag = false;
					} else if (isDescriptionTag) {
						goods.setDescription(String.copyValueOf(ch, start, length));
						isDescriptionTag = false;
					} else if (isYearTag) {
						isYearTag = false;
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						try {
							goods.setYear(format.parse(String.copyValueOf(ch, start, length)));
						} catch (ParseException e) {
							e.printStackTrace();
							successfulFlag = false;
						}
					} else if (isPriceTag) {
						goods.setPrice(Integer.parseInt(String.copyValueOf(ch, start, length)));
						isPriceTag = false;
					} else if (isVisibleTag) {
						goods.setVisible("true".equals(String.copyValueOf(ch, start, length)));
						isVisibleTag = false;
					} else if (isLocationTag) {
						root.setLocation((String.copyValueOf(ch, start, length)));
						isLocationTag = false;
					} else if (isEmailsTag) {
						emailsList.add((String.copyValueOf(ch, start, length)));
						isEmailsTag = false;
					} else if (isGoodsTag) {
						goods = new Goods();
						isGoodsTag = false;
						nameFlag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
					successfulFlag = false;
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if ("goods".equals(qName) && successfulFlag == true) { // если
																		// поля
																		// goods
																		// заполнены
																		// без
																		// сбоев
					goodsList.add(goods);
				} else if ("goods".equals(qName) && successfulFlag != true) { // если
																				// поля
																				// goods
																				// заполнены
																				// со
																				// сбоями
					successfulFlag = true;
				}
			}

			@Override
			public void endDocument() throws SAXException {
				if (emailsList != null) {
					root.setEmails(emailsList);
				}
				if (goodsList != null) {
					root.setGoods(goodsList);
				}
			}
		};
		saxParser.parse(is, handler);
		return root;
	}
}
