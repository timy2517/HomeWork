package art.home.work;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JecksonParser {
	public Root parsing() { //метод возвращает root с данными из json	
		Root root = null;
		try {
			File jsonFile = new File("shop.json");
			ObjectMapper mapper = new ObjectMapper();
			root = mapper.readValue(jsonFile, Root.class); // конвертируем json в root
		} catch (Exception e) {
			System.out.println("JECKSON Error = " + e.getMessage());
		}
		return root;
	}
}
