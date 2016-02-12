import java.awt.geom.Area;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Figure figure;
		//
		// figure = new Kvad(5);
		//
		// int s = figure.area();
		//
		// System.out.println(s);
		// ////////////////////////////////////////

		Random rand = new Random();

		int[] mas1 = new int[5];
		for (int i = 0; i < 5; i++) {
			mas1[i] = rand.nextInt(100);
		}
		int[] mas2 = new int[3];
		for (int i = 0; i < 3; i++) {
			mas2[i] = rand.nextInt(100);
		}
		int[] mas3 = new int[11];
		int[] masX = { 0, 1, 2 };

		System.arraycopy(mas1, 0, mas3, 0, mas1.length);
		System.arraycopy(mas2, 0, mas3, mas1.length, mas2.length);
		System.arraycopy(masX, 0, mas3, mas1.length + mas2.length, masX.length);

		for (int i = 0; i < 5; i++) {
			System.out.print(mas1[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print(mas2[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < 11; i++) {
			System.out.print(mas3[i] + " ");
		}

	}

}
