package work15;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*long timeStart = System.nanoTime();

		int[] mas = {1, 2, 3, 4, 5, 5, 6, 4, 3, 2, 1};
		
		int x = 0;
		Arrays.sort(mas);

		int x = -1;

		for (int i = 0; i < mas.length; i++) {
			if (i != mas.length - 1) {
				if (mas[i] != mas[i + 1]) {
					x = mas[i];
					break;
				}
				i++;
			} else
				x = mas[mas.length - 1];
		}
		
		for (int i = 0; i < mas.length; i++) {
			x = x^mas[i];
		}
		
		System.out.println(x);
		System.out.println(System.nanoTime() - timeStart);*/
		
		Random rand = new Random();
		int c = rand.nextInt(899) + 100;
		//int c = 666;
		
		int c1, c2, c3;
		
		c1 = c/100;
		c2 = (c-c1*100)/10;
		c3 = c - c1*100 - c2*10;
		
		System.out.println(c + " " + c1 + " " + c2 + " " + c3);
		
		if((c1 == c2 && c2 == c3) || (c1 == c2-1 && c2 == c3-1)){
			System.out.println("happy");
		}

	}

}
