import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

	public static void main(String[] args) {
		
		String str = "+377 29 7450269";
		String str2 = "4478 MO-7";

		str = str.replaceAll("\\D", "");
		
		Pattern pattern = Pattern.compile("^\\d{12}$");
		Pattern pattern2 = Pattern.compile("^\\d{4}+\\s+[A-Q]{2}+[-]+\\d+$");		

		Matcher matcher = pattern.matcher(str); 
		if(matcher.find()){
			System.out.println("Нашли телефон");
		}
		
		matcher = pattern2.matcher(str2); 
		if(matcher.find()){
			System.out.println("Нашли номер авто");
		}

	}

}
