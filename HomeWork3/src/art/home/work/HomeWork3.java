package art.home.work;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {

	public static void main(String[] args) {

		int mas[] = new int[10];

		scan(mas);
		print(mas);
		sortS(mas);
		print(mas);
		evenNumb(mas);

	}

	public static void scan(int mas[]) { // метод заполнения массива с
											// клавиатуры

		for (int i = 0; i < mas.length; i++) {
			
			System.out.println("Введите элемент # " + i + ":");
			
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				mas[i] = sc.nextInt();
			} else {
				System.out.println("Введено неверное значение");
				i--; //если ввод некоректный - повторяем снова
			}
		}
	}

	public static void print(int mas[]) { // метод вывода массива в консоль

		System.out.println();
		for (int i = 0; i < mas.length; i++) {

			System.out.print(mas[i] + " | ");
		}
	}

	public static void sortB(int mas[]) { // метод сортировки пузырьком

		for (int i = mas.length - 1; i > 0; i--) {

			for (int j = 0; j < i; j++) {

				if (mas[j] > mas[j + 1]) {
					int temp = mas[j];
					mas[j] = mas[j + 1];
					mas[j + 1] = temp;
				}
			}
		}

	}
	
	public static void sortS(int mas[]) {	// метод сортировки выбором
		
		for (int i = 0; i < mas.length; i++) {
	        
	        int min = mas[i];
	        int min_i = i; 
	        
	        for (int j = i+1; j < mas.length; j++) {
	            if (mas[j] < min) {
	                min = mas[j];
	                min_i = j;
	            }
	        }
	        if (i != min_i) {
	            int tmp = mas[i];
	            mas[i] = mas[min_i];
	            mas[min_i] = tmp;
	        }
	     }
		
	}
	public static void sortA(int mas[]){	// сортировка методом sort() класса Arrays
		
		Arrays.sort(mas);
	}

	public static void evenNumb(int mas[]) { // метод вывода четных чисел
												// массива

		System.out.println("\nЧетные элементы массива: \n");
		for (int i = 0; i < mas.length; i++) {

			if (mas[i] % 2 != 1) {
				System.out.print(mas[i] + " | ");
			}
		}
	}

}
