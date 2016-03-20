package art.home.work;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//JecksonParser jp = new JecksonParser();
		//System.out.println(jp.parsing().toString());
		
		//GSONParser gp = new GSONParser();		
		//System.out.println(gp.parsing().toString());
		
		XMLParser x = new XMLParser();
		System.out.println(x.parsing().toString());
	}

}
