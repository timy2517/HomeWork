package art.home.work;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	//private static String text = "This new text \n This new text2 \n This new text3 \n This new text4\n";
	private static String fileName = "C://a.txt";

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		
		FileWorker.write(fileName, text); //запись в файл
		
		String textFromFile = FileWorker.read(fileName); //чтение из файла
	    System.out.println(textFromFile);

	}

}
