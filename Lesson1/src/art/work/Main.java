package art.work;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * try {
		 * 
		 * int[] array = new int[5]; int a = array[6];
		 * 
		 * int b = 1 / 0;
		 * 
		 * 
		 * } catch (ArithmeticException e) {
		 * System.out.println("Main main() e = " + e.toString()); }catch
		 * (IndexOutOfBoundsException e) { System.out.println("Main main() e = "
		 * + e.toString()); }
		 */
		Integer a = 0, b = 0;
		double c;

		Scanner sc = new Scanner(System.in);

		try {

			
			a = Integer.valueOf(sc.nextLine());
			b = Integer.valueOf(sc.nextLine());

			c = a / b;
			
			System.out.println(c);

		} catch (NumberFormatException e) {
			System.out.println("Неверный формат строки! " + e);

		} catch (ArithmeticException e) {
			System.out.println("На 0 делить нельзя " + e);

		}



	/*	try {
			int b = 1 / 0;

			int[] array = new int[5];
			int a = array[6];

		} catch (ArithmeticException e) {
			System.out.println("Main main() e = " + e.toString());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Main main() e = " + e.toString());
		} catch (Exception e) {
			System.out.println("Main main() e = " + e.toString());
		} finally {
			System.out.println("finnaly");
		}*/

	}

}
