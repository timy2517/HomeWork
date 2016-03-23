package art.home.work.parsing;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

import art.home.work.models.Root;

public class JacksonParser extends ParserDownloader {
	protected static final String JSON_URL = "http://kiparo.ru/t/shop.json";
	protected static final String JSON_FILE_NAME = "shop.json";



	// реализуем синглтон
	private JacksonParser() {
	}

	private static class JecksonParserHolder {
		private final static JacksonParser instance = new JacksonParser();
	}

	public static JacksonParser getInstance() {
		return JecksonParserHolder.instance;
	}



	public void parsing() {
		// метод возвращает root с данными из json
		try {
			File jsonFile = Downloader.downloadFile(JSON_URL, JSON_FILE_NAME);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ObjectMapper mapper = new ObjectMapper();

			mapper.setDateFormat(dateFormat);
			setRoot(mapper.readValue(jsonFile, Root.class)); // конвертируем json
															// в root
		} catch (Exception e) {
			System.out.println("JECKSON Error = " + e.getMessage());
		}
		
	}
}
