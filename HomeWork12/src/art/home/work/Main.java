package art.home.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String temp = null;
		int counter1 = 0, counter2 = 1;

		ArrayList<String> stringList = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		while (true) {// заполняем массив
			temp = sc.nextLine();
			if (temp.equals("exit")) {// ввод "exit" - выход
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

				if (stringList.get(counter1).equals(stringList.get(counter2))) {// если нашли идентичные строки
					stringList.remove(counter2);// удаляем вторую
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

		man.add(new Human("Maaa", "Mbbb", "Mccc"));
		man.add(new Human("Meee", "Mfff", "Mggg"));
		man.add(new Human("Mhhh", "Miii", "Myyy"));
		man.add(new Human("Mkkk", "Mlll", "Mnnn"));
		man.add(new Human("Mooo", "Mppp", "Mrrr"));

		woman.add(new Human("Waaa", "Wbbb", "Wccc"));
		woman.add(new Human("Weee", "Wfff", "Wggg"));
		woman.add(new Human("Whhh", "Wiii", "Wyyy"));
		woman.add(new Human("Wkkk", "Wlll", "Wnnn"));
		woman.add(new Human("Wooo", "Wppp", "Wrrr"));

		Map<String, ArrayList<Human>> hashmap = new HashMap<String, ArrayList<Human>>();

		hashmap.put("man", man);
		hashmap.put("woman", woman);

		Random random = new Random();

		System.out.println("1 - man / !1 - woman");

		int x = 100;

		while (x != 0) {
			while (true) {
				if (sc.hasNextInt()) {
					x = sc.nextInt();
					break;
				} else {
					System.out.println("Permission incorrect value");
				}
			}

			if (x == 1) {
				System.out.println(hashmap.get("man").get(random.nextInt(man.size())).toString());
			} else {
				System.out.println(hashmap.get("woman").get(random.nextInt(woman.size())).toString());
			}
		}

	}

}
