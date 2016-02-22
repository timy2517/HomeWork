import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		/////////////////////////////////// 1
		/////////////////////////////////// ////////////////////////////////////

		String str = "hellowoooorld";

		String[] mas1 = str.split("([a-zA-Z])\\1+");
		String[] mas2 = new String[mas1.length - 1];

		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb2 = new StringBuilder("");

		for (int i = 0; i < mas1.length; i++) {

			if (i < mas2.length) {

				mas2[i] = sb.substring((str.indexOf(mas1[i]) + mas1[i].length()), str.indexOf(mas1[i + 1]));

				sb2 = sb2.append(mas1[i]).append(mas2[i].charAt(0) + Integer.toString(mas2[i].length()));

			} else {
				sb2 = sb2.append(mas1[i]);
			}

		}

		System.out.println(sb2);

		//////////////////////////////////// 2
		//////////////////////////////////// /////////////////////////////////////

		String fileName = "x5_6xxs8da.xml";
		String temp;

		if (fileName.contains(".")) {

			temp = fileName.replaceAll("[a-zA-Z0-9]{1,}$", "");

			Pattern pattern = Pattern.compile("[a-zA-Z0-9]{1,}$");

			Matcher matcher = pattern.matcher(fileName);

			if (matcher.find()) {

				fileName = fileName.substring(temp.length());
				System.out.println("Format: " + fileName);
				if(!(fileName.equalsIgnoreCase("xml") || fileName.equalsIgnoreCase("json"))){
					
					System.out.println("Incorrect format");
				}
			} else
				System.out.println("Error");
		} else
			System.out.println("Error");

	}

}
