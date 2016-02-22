


import java.util.Scanner;

public class UI implements UiInterface{
	
	private CashDispenser cd;
	
	public UI(){
		cd = new CashDispenser(10, 10, 10);
		cd.setUiInterface(this);
	}

	
	public int scanKey() {

		int x;

		while (true) {

			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				break;
			} else {
				printString("Permission incorrect value");
			}
		}
		return x;

	}
	public void mainMenu() {

		while (true) {
			String menu = "1 - Withdraw money\n2 - Add money into the ATM\n3 - Residue from an ATM\n0 - Exit\nSelect: ";
			printString("-----------------------------");
			printString(menu);

			switch (scanKey()) {
			case 1:
				printString("Please enter the amount: ");
				cd.getMoney(scanKey());
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
	@Override
	public void printString(String str) {
		
		System.out.println(str);
		
	}

}
