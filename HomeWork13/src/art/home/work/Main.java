package art.home.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		List<ElementMy> listMy = new ArrayList<ElementMy>();
		ElementMy elementMy = new ElementMy();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		File file = new File("test.xml");
		InputStream inputStream = new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");

		DefaultHandler handler = new DefaultHandler() {
			
			boolean isAgeTag = false;
			boolean isIdTag = false;
			boolean isIsDegreeTag = false;
			boolean isNameTag = false;
			boolean isSurnameTag = false;

			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				isAgeTag = "age".equals(qName);
				isIdTag = "id".equals(qName);
				isIsDegreeTag = "isdegree".equals(qName);
				isNameTag = "name".equals(qName);
				isSurnameTag = "surname".equals(qName);
			}

			public void characters(char[] ch, int start, int length) throws SAXException {

				if (isAgeTag) {
					//System.out.println(Integer.parseInt(String.copyValueOf(ch, start, length)));
					elementMy.setAge(Integer.parseInt(String.copyValueOf(ch, start, length)));
					isAgeTag = false;
				}
				if (isIdTag) {
					//System.out.println(Integer.parseInt(String.copyValueOf(ch, start, length)));
					elementMy.setId(Integer.parseInt(String.copyValueOf(ch, start, length)));
					isIdTag = false;
				}

				if (isIsDegreeTag) {
					//System.out.println(Boolean.valueOf(String.copyValueOf(ch, start, length)));
					elementMy.setDegree(Boolean.valueOf(String.copyValueOf(ch, start, length)));
					isIsDegreeTag = false;
				}
				if (isNameTag) {
					//System.out.println(String.copyValueOf(ch, start, length));
					elementMy.setName(String.copyValueOf(ch, start, length));
					isNameTag = false;
				}
				if (isSurnameTag) {
					//System.out.println(String.copyValueOf(ch, start, length));
					elementMy.setSurName(String.copyValueOf(ch, start, length));
					isSurnameTag = false;
					
				}

			}

			public void endElement(String uri, String localName, String qName) throws SAXException {
				if(qName.equals("element")){
					listMy.add(elementMy);
				}
				
			}


		};
		
		saxParser.parse(is, handler);
		System.out.println(listMy.toString());

	}

}
