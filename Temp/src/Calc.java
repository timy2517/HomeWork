import java.util.Scanner;

public class Calc {

	public void menuCalc() throws MyException {
		String menuCalc = ("1 - Cëîćĺíčĺ a+b.\n2 - Âű÷ĺňŕíčĺ ŕ-b.\n3 - Óěíîćĺíčĺ a*b.\n4 - Äĺëĺíčĺ a/b.");
		System.out.println(menuCalc);
		
		try {
			switch (scan()) {
			case 1:
				summ();
				break;
			case 2:
				vychet();
				break;
			case 3:
				umnoj();
				break;
			case 4:
				delen();
				break;

			default:

				throw new MyException("Íĺâĺđíîĺ çíŕ÷ĺíčĺ.");
			}
		} catch (Exception e) {
		}
	}

	public void summ() {
		Numb temp = new Numb(0, 0);
		double c;
		temp = ab();
		c = temp.getNumbA() + temp.getNumbB();
		System.out.println(c);

	}

	public void vychet() {
		Numb temp = new Numb(0, 0);
		double c;
		c = temp.getNumbA() - temp.getNumbB();
		System.out.println(c);
	}

	public void umnoj() {
		Numb temp = new Numb(0, 0);
		double c;
		c = temp.getNumbA() * temp.getNumbB();
		System.out.println(c);
	}

	public void delen() throws MyException {

		try {
			Numb temp = new Numb(0, 0);
			double c;
			c = temp.getNumbA() / temp.getNumbB();
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("Äĺëĺíčĺ íŕ íîëü");
		}
	}

	public Numb ab() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ââĺäčňĺ ÷čńëî a.");
		double a = sc.nextDouble();
		System.out.println("Ââĺäčňĺ ÷čńëî b.");
		double b = sc.nextDouble();

		Numb newNumb = new Numb(a, b);
		return newNumb;

	}

	private int scan() throws MyException {

		int x;

		while (true) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				break;
			} else {
				throw new MyException("Ââĺäĺíî íĺďđŕâčëüíîĺ çíŕ÷ĺíčĺ.");
			}
		}
		return x;

	}
}