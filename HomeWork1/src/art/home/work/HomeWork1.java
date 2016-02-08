package art.home.work;


import java.util.Random;

public class HomeWork1 {

	public static void main(String[] args) {

		////////////////////////// 1 ///////////////////////////

		String str = "sdasjhkgfjsdkfjdsl";
		System.out.println(str.length()); // Длина строки

		String str1, str2;
		str1 = str.substring(0, str.length() / 2); // первая половина
		str2 = str.substring(str.length() / 2); // вторая половина

		System.out.println(str1 + "\n" + str2);

		////////////////////////// 2 ///////////////////////////

		Random rand = new Random();

		int a = rand.nextInt(); // случайное число int
		str = Integer.toString(a); // int to String

		if (str.charAt(str.length() - 1) == '7') { //сравниваем последнюю цифру

			System.out.println("Seven");

		} else
			System.out.println("Not Seven");

		////////////////////////// 3 ///////////////////////////

		int x = 5, y = 10, r = 7; // стороны прямоугольника и радиус кортонки

		if (r*2 > (Math.sqrt(x*x + y*y))) { //если диаметр картонки больше диагонали прямоугольника

			System.out.println("Closes");

		} else
			System.out.println("Does not close");
		
		////////////////////////// 4 ///////////////////////////
		
		int sum = rand.nextInt(1000); // положительная сумма до 1000
		
		str = Integer.toString(sum);
		
		char lastNumber = str.charAt(str.length() - 1); // падеж зависит от последней цифры - извлекаем ее
		
		switch (lastNumber) { //switch (str.charAt(str.length() - 1)) -экономия памяти
		case '1':
			System.out.println(sum + " рубль");
			break;
		
		case '0': case '5': case '6': case '7': case '8': case '9':
			System.out.println(sum + " рублей");
			break;
			
		case '2': case '3': case '4':
			System.out.println(sum + " рубля");
			break;

		}
		
		/////////////////////////// 5 ////////////////////////////
		
		str = "#asd?sdf#?dsfg?dd#";
		
		for(int i=0; i<str.length(); i++){ //запускаем replace() для каждого символа
			
			str = str.replace("#", "");
			str = str.replace("?", "HELLO");
		}
		System.out.println(str);

	}

}
