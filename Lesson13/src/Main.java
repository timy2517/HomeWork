import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.*;

public class Main {

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("sdf", "ddd");
		map.put("ffff", "jjjjj");
		map.put("ffddss", "nnnnn");

		Iterator iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) iterator.next();
			System.out.println(pair.getKey() + " | " + pair.getValue());
		}

	}

}
