package art.home.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
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

	List<String> emails = new ArrayList<String>();
	List<Goods> goods = new ArrayList<Goods>();
	Root root = new Root();

	// метод возвращает root с данными из xml
	public Root parsing()
			throws ParserConfigurationException, SAXException, FileNotFoundException, UnsupportedEncodingException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		File file = new File("test.xml");
		InputStream inputStream = new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");

		return root;
	}

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

		boolean nameFlag = true; //когда true - заполняется goods
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("name") || !nameFlag) {
				isShopNameTag = true;
			}else if(qName.equals("name") || nameFlag){
				isGoodsNameTag = true;
			}else {
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
			if(isIdTag){
				
			}else if(isIdTag){
				goods.setId(Integer.parseInt(String.copyValueOf(ch, start, length)));
				isIdTag = false;
			}else if(isShopNameTag){
				
			}else if(isGoodsNameTag){
				
			}else if(isDescriptionTag){
				
			}else if(isYearTag){
				
			}else if(isPriceTag){
				
			}else if(isVisibleTag){
				
			}else if(isLocationTag){
				
			}else if(isEmailsTag){
				
			}else if(isGoodsTag){
				
			}
			
		}

		@Override
		public void endDocument() throws SAXException {
			
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			
		}

	};

}
