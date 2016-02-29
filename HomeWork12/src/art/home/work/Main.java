package art.home.work;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String temp = null;
		int counter1 = 0, counter2 = 1;

		ArrayList<String> stringList = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		while (true) {// заполняем массив
			temp = sc.nextLine();
			if (temp.equals("exit")) {// при вводе "exit" завершаем ввод
				break;
			} else {
				stringList.add(temp);
			}
		}

		System.out.println(stringList);

		for (int i = 0; i < stringList.size(); i++) {// удаление всех "а"
			temp = stringList.get(i).replaceAll("a", "");
			stringList.set(i, temp);
		}
		System.out.println(stringList);
		
		////////////////////// 2 ///////////////////////////////

		while (counter1 < stringList.size()) {
			if (counter2 < stringList.size()) {
				
				if (stringList.get(counter1).equals(stringList.get(counter2))) {//сравниваем 2 элемента
					stringList.remove(counter2);//удаляем идентичный эл-т
				} else {
					counter2++;
				}
				
			} else {
				counter1++;
				counter2 = counter1 + 1;
			}
		}
		System.out.println(stringList);
		
		////////////////////// 3 ///////////////////////////////
		
		ArrayList<Human> man = new ArrayList<Human>();
		ArrayList<Human> woman = new ArrayList<Human>();

	}

}
