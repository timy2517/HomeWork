package art.home.work;

import java.util.List;
import java.util.Scanner;

public class Shop {
	
	JecksonParser jp = new JecksonParser();
	Root root = jp.parsing();
	List<Goods> goodsOfShop = root.getGoods();
	
	private void Find(int id){
		for(int i = 0; i < goodsOfShop.size(); i++){
			if(goodsOfShop.get(i).getId() == id){
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}
	private void Find(String name){
		for(int i = 0; i < goodsOfShop.size(); i++){
			if(goodsOfShop.get(i).getName().equals(name)){
				System.out.println(goodsOfShop.get(i).toString());
				return;
			}
		}
		System.out.println("goods not found!");
	}
	private void Find(int start, int end){}
	
	private void sortByName(){}
	private void sortByCost(){}
	
	class Menu{
		public void menu(){
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
