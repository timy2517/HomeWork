package art.home.work;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		//JecksonParser jp = new JecksonParser();
		//System.out.println(jp.parsing().toString());
		
		//GSONParser gp = new GSONParser();		
		//System.out.println(gp.parsing().toString());
		
		XMLParser x = new XMLParser();
		try {
			System.out.println(x.parsing().toString());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(x.goodsList.toString());
	}

}
