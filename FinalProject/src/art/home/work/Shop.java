package art.home.work;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Shop {

	JecksonParser jp = new JecksonParser();
	Root root = jp.parsing();
	List<Goods> goodsOfShop = root.getGoods();

	private void Find(int id) {//поиск по id
		for (int i = 0; i < goodsOfShop.size(); i++) {
			if (goodsOfShop.get(i).getId() == id) {
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}

	private void Find(String name) {//поиск по имени
		for (int i = 0; i < goodsOfShop.size(); i++) {
			if (goodsOfShop.get(i).getName().equals(name)) {
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}

	private void Find(int start, int end) {//поиск в диапазоне цен
		boolean flag = false;
		for (int i = 0; i < goodsOfShop.size(); i++) {
			if (goodsOfShop.get(i).getPrice() >= start && goodsOfShop.get(i).getPrice() <= end) {
				System.out.println(goodsOfShop.get(i).toString());
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("goods not found!");
		} else
			flag = !flag;
	}

	private void sortByName() { //сортировка по имени
		goodsOfShop.sort(new SortByName());
		System.out.println(goodsOfShop.toString());
	}

	private void sortByPrice() { //сортировка по цене
		goodsOfShop.sort(new SortByPrice());
		System.out.println(goodsOfShop.toString());
	}

	class SortByName implements Comparator<Goods> { //компаратор для сортировки по имени

		public int compare(Goods obj1, Goods obj2) {

			String str1 = obj1.getName();
			String str2 = obj2.getName();

			return str1.compareTo(str2);
		}
	}

	class SortByPrice implements Comparator<Goods> { //компаратор для сортировки по цене

		public int compare(Goods obj1, Goods obj2) {

			int price1 = obj1.getPrice();
			int price2 = obj2.getPrice();

			if (price1 > price2) {
				return 1;
			} else if (price1 < price2) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	class Menu {
		public void menu() {
			while (true) {
				String mainMenu = "1 - \n2 - \n3 - \n4 - \n5 - \n0 - Exit\nSelect: ";
				System.out.println(mainMenu);
				switch (scanKay()) {
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 0:
					return;
				}
			}
		}

		private int scanKay() {

			int x;

			while (true) {
				Scanner sc = new Scanner(System.in);
				if (sc.hasNextInt()) {
					x = sc.nextInt();
					break;
				} else {
					System.out.println("Permission incorrect value");
				}
			}
			return x;

		}
	}

}
