package art.work;

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

		try {
			int b = 1 / 0;

			int[] array = new int[5];
			int a = array[6];

		} catch (Exception e) {
			System.out.println("Main main() e = " + e.toString());
		}
	}

}
