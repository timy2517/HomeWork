package art.home.work;

import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {

	public static void main(String[] args) {

		///////////////////////////// 1 /////////////////////////////////////

		int[] mas = { 45, 23, 12, 857, 11, 0, 79, 34, 666, 2 };
		int minValue = mas[0];
		int maxValue = mas[0];
		int minIndex = 0, maxIndex = 0; // номер позиции минимального и
										// максимального числа

		for (int i = 1; i < 10; i++) {

			if (mas[i] < minValue) { // поиск минимального числа и его позиции
				minValue = mas[i];
				minIndex = i;
			}

			if (mas[i] > maxValue) { // поиск максимального числа и его позиции
				maxValue = mas[i];
				maxIndex = i;
			}
		}
		System.out.println("min value = " + minValue + "\n" + "max value = " + maxValue);

		mas[minIndex] = 0; // замена по
		mas[maxIndex] = 99; // условию

		System.out.print("[" + mas[0] + ", "); // вывод 1-го элемента
		for (int i = 1; i < 9; i++) { // вывод элементов 2-9

			System.out.print(mas[i] + ", ");
		}
		System.out.println(mas[0] + "]"); // вывод последнего элемента

		////////////////////////////////////// 2
		////////////////////////////////////// /////////////////////////////////////

		float[] masFloat = { 2, 3, 4, 2, 6, 2, 9, 2, 4, 5 };
		int index = 1; // номер повторившегося элемента массива
		int temp = 1; // количество повторений текущего элемента

		Arrays.sort(masFloat); // сортировка по возрастанию

		for (int i = 0; i < 10; i++) {

			for (int j = i + 1; j < 10; j++) {

				if (masFloat[i] == masFloat[j]) { // сравниваем текущий элемент
													// со следующим

					index = i;
					temp++;

				} else {
					if (temp > 1) { // если предыдущий элемент повторялся -
									// печатаем его
						System.out.println("[" + masFloat[index] + "]" + " - повторений " + temp);
						temp = 1; // сбрасываем счетчики
						i = j - 1; // пропускаем совпавшие элементы
						break;
					}

				}
				break;

			}
		}

		////////////////////////////////////////// 3
		////////////////////////////////////////// ///////////////////////////////////////////
		int[] mas1 = new int[10];

		Random rand = new Random();
		int tmp = 0;

		for (int i = 0; i < 10; i++) {
			mas1[i] = rand.nextInt(100);
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(mas1[i] + " ");
		}

		for (int i = 0; i < mas1.length / 2; i++) {
			tmp = mas1[i];
			mas1[i] = mas1[mas1.length - i - 1];
			mas1[mas1.length - i - 1] = tmp;
		}
		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.print(mas1[i] + " ");
		}

	}

}
