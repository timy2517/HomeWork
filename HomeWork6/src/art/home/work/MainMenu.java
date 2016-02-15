package art.home.work;

import java.util.Scanner;

public class MainMenu {

	CashDispenser cd = new CashDispenser(10, 10, 10);

	public void mainMenu() {

		while (true) {
			String menu = "1 - Withdraw money\n2 - Add money into the ATM\n3 - Residue from an ATM\n0 - Exit\nSelect: ";
			System.out.println();
			System.out.println(menu);

			switch (cd.scanKay()) {
			case 1:
				System.out.println("Please enter the amount: ");
				cd.getMoney(cd.scanKay());
				break;
			case 2:
				cd.addMoney();
				break;
			case 3:
				cd.showResidue();
				break;

			case 0:
				return;

			default:
				break;
			}
		}
	}

}
