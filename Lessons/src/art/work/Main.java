package art.work;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		try{
			//инициализируем парсер
			JSONObject obj = (JSONObject)parser.parse(new FileReader("test.json"));
			
			//получаем переменную name
			String name = (String) obj.get("name");
			System.out.println("NAME = " + name);
			
			//полуаем массив объектов, находящийся в переменной people
			JSONArray jsonArray = (JSONArray) obj.get("people");
			
			for(int i = 0; i < jsonArray.size(); i++){
				
				System.out.println("-----------------------");
				JSONObject jsonobject = (JSONObject) jsonArray.get(i);
				
				long id = (long) jsonobject.get("id");
				System.out.println("id = "+id);
				
				String nameInner = (String) jsonobject.get("name");
				System.out.println("name = "+nameInner);
				
				String surnameInner = (String) jsonobject.get("surname");
				System.out.println("surname = "+surnameInner);
				
				long age = (long) jsonobject.get("age");
				System.out.println("age = "+age);
				
				boolean isDegree = (boolean) jsonobject.get("isDegree");
				System.out.println("isDegree = "+isDegree);
				
			}
 			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
