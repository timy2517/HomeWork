import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		Student[] mas = new Student[3];

		SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
		
		GregorianCalendar calendar = new GregorianCalendar();
		Date CurrentTime = calendar.getTime();

		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {

			mas[i] = new Student();

			System.out.println("Name: ");
			mas[i].setName(sc.nextLine());

			System.out.println("Surname: ");
			mas[i].setSurname(sc.nextLine());

			System.out.println("Age: ");
			while (true) {
				String temp = sc.nextLine();
				Pattern pattern = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$");
				Matcher matcher = pattern.matcher(temp);

				if (matcher.find()) {
					try {
						Date t = format.parse(temp);
						mas[i].setAge(t);
						break;
					} catch (ParseException e) {
						System.out.println("формат неверный");
					}
					break;
				} else {
					System.out.println("Permission incorrect value");
					break;
				}
			}
		}
		for (int j = 0; j < 3; j++) {
			System.out.println(mas[j].getName() + " " + mas[j].getSurname() + " " + format.format(mas[j].getAge()));
		}

		
		long mm = 0;

		for (int i = 0; i < 3; i++) {
			mm += CurrentTime.getTime() - mas[i].getAge().getTime();
		}
		long average = mm / 3;

		int y, m;

		y = (int)(average / 31536000000L);
		m = (int) ((average % 31536000000L) / 2592000000L);

		System.out.println("Years: " + y + " Monts: " + m);

	}

}
