import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args) {
		
		String str = "+3775 29d7 4-502 69";

		str = str.replaceAll("\\D", "");


		//шаблон для регулярного выражения по которому будет поиск
		//Pattern pattern = Pattern.compile("^[A-Za-z]+#+[0-9]+$");
		//Pattern pattern = Pattern.compile("^\\D+\\#\\d+$");
		//Pattern pattern = Pattern.compile("^\\d{4}+\\s+[A-Q]{2}+[-]+\\d+$");
		Pattern pattern = Pattern.compile("^\\d{12}$");
		
		//Matcher - объект который умеет находить и сравнивать по заданному шаблону (паттерну)
		Matcher matcher = pattern.matcher(str); //посмотреть групп
		
		System.out.println(str);
		
		//поиск совпадений - в ответ прихоит тру или фолз
		if(matcher.find()){
			System.out.println("Нашли");
		}
		
		

	}

}
