//http://vandrouki.by/
package art.home.work.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		Shop shop = new Shop();//инициализируем магаз
		shop.startShop(); //запускаем магаз
	}

}
