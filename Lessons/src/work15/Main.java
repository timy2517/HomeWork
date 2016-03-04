package work15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		long timeStart = System.nanoTime();
		
		int[] mas = {1, 2, 3, 4, 5, 5, 6, 4, 3, 2, 1};
		
		//Map < Integer , Integer > map = new HashMap < Integer, Integer> () ;
		
		
		
		////////////////s//////////////
		//Arrays.sort(mas);

		int x = 0;

		for (int i = 0; i < mas.length; i++) {
			
			x = x^mas[i];
			/*int x = 0;
			for (int i = 0; i < mas.length; i++) {
				x = x^mas[i];
			}*/
			/*if (map.containsKey(mas[i]))
			{
				map.remove(mas[i]);
			}else
			{
				map.put(mas[i],1);
			}*/
			/*
			
			if (i != mas.length - 1) {
				if (mas[i] != mas[i + 1]) {
					x = mas[i];
					break;
				}
				i++;
			} else
				x = mas[mas.length - 1];*/
		}
		
		////////////////////////////////
		long stop=System.nanoTime() - timeStart;
		
		//System.out.println(map.toString());
		//System.out.println(stop);
		System.out.println(x);
		System.out.println(stop);
		
		/*Random rand = new Random();
		int c = rand.nextInt(899) + 100;
		//int c = 666;
		
		int c1, c2, c3;
		
		c1 = c/100;
		c2 = (c-c1*100)/10;
		c3 = c - c1*100 - c2*10;
		
		System.out.println(c + " " + c1 + " " + c2 + " " + c3);
		
		if((c1 == c2 && c2 == c3) || (c1 == c2-1 && c2 == c3-1)){
			System.out.println("happy");
		}*/
		
		

	}

}
