package art.home.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			File jsonFile = new File("shop.json");
			Root root = null;

			ObjectMapper mapper = new ObjectMapper();

			root = mapper.readValue(jsonFile, Root.class);
						
			System.out.println(root.toString());
		} catch (Exception e) {
			System.out.println("JECKSON Error = " + e.getMessage());
		}
	}

}