package art.home.work.main;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import art.home.work.models.Goods;
import art.home.work.models.Root;
import art.home.work.parsing.GSONParser;
import art.home.work.parsing.JecksonParser;
import art.home.work.parsing.XMLParser;


public class Shop {
	// инициализация парсеров
	XMLParser xmlParser = XMLParser.getInstance();
	GSONParser gsonParser = GSONParser.getInstance();
	JecksonParser jecksonParser = JecksonParser.getInstance();

	Root root;
	List<Goods> goodsOfShop;
	Scanner sc;

	public void startShop() {// инициализация структур данных, старт меню
		Menu menu = new Menu();
		root = xmlParser.parsing();
		goodsOfShop = root.getGoods();
		menu.menu();
	}

	private int scanKay() { //сканирование одного int

		int x;

		while (true) {
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				break;
			} else {
				System.out.println("Permission incorrect value");
				System.out.println("Select: ");
			}
		}
		return x;
	}

	private void find(int id) {// поиск по id
		for (int i = 0; i < goodsOfShop.size(); i++) {
			if (goodsOfShop.get(i).getId() == id) {
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}

	private void find(String name) {// поиск по имени
		for (int i = 0; i < goodsOfShop.size(); i++) {
			if (goodsOfShop.get(i).getName().equals(name)) {
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}

	private void find(int start, int end) {// поиск в диапазоне цен
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

	private void sortByName() { // сортировка по имени
		// goodsOfShop.sort(new SortByName());
		System.out.println(goodsOfShop.toString());
	}

	private void sortByPrice() { // сортировка по цене
		goodsOfShop.sort(new SortByPrice());
		System.out.println(goodsOfShop.toString());
	}

	private void infoByShop() { //вывод информации о магазине
		System.out.println(
				"\n" + root.getName() + "\n" + root.getLocation() + "\n" + "Emails: " + root.getEmails().toString());
	}

	class SortByName implements Comparator<Goods> { // компаратор для сортировки
													// по имени
		public int compare(Goods obj1, Goods obj2) {
			String str1 = obj1.getName();
			String str2 = obj2.getName();
			return str1.compareTo(str2);
		}
	}

	class SortByPrice implements Comparator<Goods> { // компаратор для
														// сортировки по цене
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

	final private class Menu {
		public void menu() {
			while (true) {
				String mainMenu = "1 - Update the list of goods\n2 - Show the list of goods\n3 - Find by name\n4 - Find by id\n5 - Sort by name\n6 - Sort by price\n7 - Search in price range\n8 - Show info by shop\n0 - Exit\nSelect: ";
				String line = "----------------------------------";
				System.out.println("-------------  Menu --------------");
				System.out.println(mainMenu);
				switch (scanKay()) {
				case 1:
					System.out.println(line);

					break;
				case 2:
					System.out.println(line);
					System.out.println(goodsOfShop.toString());
					break;
				case 3:
					System.out.println(line);
					System.out.println("Enter the product name");
					sc = new Scanner(System.in);
					find(sc.nextLine());
					break;
				case 4:
					System.out.println(line);
					System.out.println("Enter the product id");
					find(scanKay());
					break;
				case 5:
					System.out.println(line);
					sortByName();
					break;
				case 6:
					System.out.println(line);
					sortByPrice();
					break;
				case 7:
					System.out.println(line);
					System.out.println("Enter the start and end price");
					find(scanKay(), scanKay());
					break;
				case 8:
					System.out.println(line);
					infoByShop();
					break;
				case 0:
					return;
				}

			}
		}

	}

}