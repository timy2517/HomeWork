package art.home.work.parsing;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

import art.home.work.models.Root;


public class JecksonParser extends Downloader{
	//реализуем синглтон
	private JecksonParser() {
	}
	private static class JecksonParserHolder{
		private final static JecksonParser instance = new JecksonParser();
	}
	public static JecksonParser getInstance() {
		return JecksonParserHolder.instance;
	}
	
	public Root parsing() { // метод возвращает root с данными из json
		Root root = null;
		try {
			File jsonFile = downloadFile(JSON_URL, JSON_FILE_NAME);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ObjectMapper mapper = new ObjectMapper();

			mapper.setDateFormat(dateFormat);
			root = mapper.readValue(jsonFile, Root.class); // конвертируем json в root
		} catch (Exception e) {
			System.out.println("JECKSON Error = " + e.getMessage());
		}
		return root;
	}
}
