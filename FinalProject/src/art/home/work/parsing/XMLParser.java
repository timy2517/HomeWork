package art.home.work.parsing;

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

import art.home.work.models.Goods;
import art.home.work.models.Root;

public class XMLParser extends ParserDownloader {

	protected static final String XML_URL = "http://kiparo.ru/t/shop.xml";
	protected static final String XML_FILE_NAME = "shop.xml";


	// реализуем синглтон
	private XMLParser() {
	}

	private static class XMLParserHolder {
		private final static XMLParser instance = new XMLParser();
	}

	public static XMLParser getInstance() {
		return XMLParserHolder.instance;
	}

	// метод возвращает root с данными из xml
	public void parsing() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		Reader reader = null;
		File file = Downloader.downloadFile(XML_URL, XML_FILE_NAME);
		InputStream inputStream = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader = new InputStreamReader(inputStream, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");
		DefaultHandler handler = new DefaultHandler() {

			List<String> emailsList = new ArrayList<String>();
			List<Goods> goodsOfShop;

			Goods goods;

			boolean isIdTag = false;
			boolean isNameTag = false;
			boolean isDescriptionTag = false;
			boolean isYearTag = false;
			boolean isPriceTag = false;
			boolean isVisibleTag = false;
			boolean isLocationTag = false;
			boolean isEmailsTag = false;
			boolean isGoodsTag = false;

			// boolean nameFlag = false; // когда true - заполняется goods
			boolean successfulFlag = true; // если возникла ошибка заполнения
											// полей - элемент не добавляется

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {

				if (qName.equals("goodsOfShop")) {
					goodsOfShop = new ArrayList<Goods>();
				} else if (qName.equals("goods")) {
					isGoodsTag = true;
					goods = new Goods();
				} else {
					isIdTag = "id".equals(qName);
					isDescriptionTag = "description".equals(qName);
					isYearTag = "year".equals(qName);
					isPriceTag = "price".equals(qName);
					isVisibleTag = "visible".equals(qName);
					isLocationTag = "location".equals(qName);
					isEmailsTag = "emails".equals(qName);
					isNameTag = "name".equals(qName);
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				try {

					if (isGoodsTag) {

						if (isIdTag) {
							goods.setId(Integer.parseInt(String.copyValueOf(ch, start, length)));
						} else if (isNameTag) {
							goods.setName(String.copyValueOf(ch, start, length));
						} else if (isDescriptionTag) {
							goods.setDescription(String.copyValueOf(ch, start, length));
						} else if (isYearTag) {
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							try {
								goods.setYear(format.parse(String.copyValueOf(ch, start, length)));
							} catch (ParseException e) {
								e.printStackTrace();
								successfulFlag = false;
							}
						} else if (isPriceTag) {
							goods.setPrice(Integer.parseInt(String.copyValueOf(ch, start, length)));
						} else if (isVisibleTag) {
							goods.setVisible("true".equals(String.copyValueOf(ch, start, length)));
						}
					} else if (isNameTag) {
						root.setName(String.copyValueOf(ch, start, length));
					} else if (isLocationTag) {
						root.setLocation((String.copyValueOf(ch, start, length)));
					} else if (isEmailsTag) {
						emailsList.add((String.copyValueOf(ch, start, length)));
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
					isGoodsTag = false;
					goodsOfShop.add(goods);
				} else if ("goods".equals(qName) && successfulFlag != true) { /// если
																				/// поля
																				/// goods
																				/// заполнены
																				/// со
																				/// сбоями
					successfulFlag = true;
					isGoodsTag = false;
				}
				isIdTag = isDescriptionTag = isEmailsTag = isPriceTag = isVisibleTag = isYearTag = isLocationTag = isNameTag = false;
			}

			@Override
			public void endDocument() throws SAXException {
				if (emailsList != null) {
					root.setEmails(emailsList);
				}
				if (goodsOfShop != null) {
					root.setGoods(goodsOfShop);
				}
			}
		};
		try {
			saxParser.parse(is, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}