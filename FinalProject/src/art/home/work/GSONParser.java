package art.home.work;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONParser {
	public Root parsing() { //метод возвращает root с данными из json	
		Root root = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("shop.json"));
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setDateFormat("yyyy-MM-dd");
			Gson gson = gsonBuilder.create();
			root = gson.fromJson(reader, Root.class); // конвертируем json в root
		} catch (Exception e) {
			System.out.println("GSON Error = " + e.getMessage());
		}
		return root;
	}
}
