package art.home.work;

import java.util.Scanner;

public class CashDispenser {

	private static final int TWENTY = 20; // доступные номиналы
	private static final int FIFTY = 50;
	private static final int HUNDRED = 100;

	private int twenty, tTemp; // кол-во купюр в банкомате и выдаваемых купюр
								// номиналом 20
	private int fifty, fTemp; // кол-во купюр в банкомате и выдаваемых купюр
								// номиналом 50
	private int hundred, hTemp; // кол-во купюр в банкомате и выдаваемых купюр
								// номиналом 100

	public CashDispenser(int twenty, int fifty, int hundred) { // конструктор
		this.twenty = twenty;
		this.fifty = fifty;
		this.hundred = hundred;
	}

	public boolean getMoney(int sum) { // метод выдачи денег

		if (sum % 10 != 0) {
			System.out.println("Entered an incorrect amount");
			return false;
		}

///////////////////////////// вычисление кол-ва купюр по 100 ////////////////////
		
		if (HUNDRED * hundred >= sum) { 

			hTemp = sum / HUNDRED;

		} else if (hundred != 0) {

			hTemp = hundred;
		}
		
///////////////////////////// вычисление кол-ва купюр по 50 ////////////////////
		
		if (FIFTY * fifty >= sum - hTemp * HUNDRED) { 
			
			fTemp = (sum - hTemp * HUNDRED) / FIFTY;

		} else if (fifty != 0) {

			fTemp = fifty;
		}

///////////////////////////// вычисление кол-ва купюр по 20 ////////////////////
		
		if ((sum - hTemp * HUNDRED - fTemp * FIFTY) % TWENTY == 0) {

			if (twenty * TWENTY >= sum - hTemp * HUNDRED - fTemp * FIFTY) {

				tTemp = (sum - hTemp * HUNDRED - fTemp * FIFTY) / TWENTY;

			} else { // если денег в банкомате не хватило

				System.out.println("An ATM is not enough money");
				System.out.println("maximum amount: " + (hundred * HUNDRED + fifty * FIFTY + twenty * TWENTY));
				return false;
			}
			
		} else if (fTemp > 0) {

			fTemp--;
			tTemp = (sum - hTemp * HUNDRED - fTemp * FIFTY) / TWENTY;

		} else if (hTemp > 0) {

			hTemp--;
			fTemp++;
			tTemp = (sum - hTemp * HUNDRED - fTemp * FIFTY) / TWENTY;
		} else {
			System.out.println("Available denominations of 20, 50, 100");
			return false;
		}

		twenty -= tTemp;
		fifty -= fTemp;
		hundred -= hTemp;

		System.out.println("Your amount: " + sum);
		if (hTemp != 0)
			System.out.println(hTemp + " x " + HUNDRED);
		if (fTemp != 0)
			System.out.println(fTemp + " x " + FIFTY);
		if (tTemp != 0)
			System.out.println(tTemp + " x " + TWENTY);

		tTemp = 0;
		fTemp = 0;
		hTemp = 0;

		return true;
	}

	public void showResidue() { //вывод остатка в банкомате

		System.out.println(hundred + " x " + HUNDRED);
		System.out.println(fifty + " x " + FIFTY);
		System.out.println(twenty + " x " + TWENTY);
	}

	public void addMoney() { //добавление денег в банкомат
		System.out.println("The number of nominal value of 100 bills: ");
		hundred += scanKay();
		System.out.println("The number of nominal value of 50 bills: ");
		fifty += scanKay();
		System.out.println("The number of nominal value of 20 bills: ");
		twenty += scanKay();
	}

	public int scanKay() {

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
