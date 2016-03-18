package art.home.work;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JecksonParser {
	public Root parsing() {
		Root root = null;
		try {
			File jsonFile = new File("shop.json");
			ObjectMapper mapper = new ObjectMapper();
			root = mapper.readValue(jsonFile, Root.class);
		} catch (Exception e) {
			System.out.println("JECKSON Error = " + e.getMessage());
		}
		return root;
	}
}
