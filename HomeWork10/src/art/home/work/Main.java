package art.home.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		
		ArrayList<Student> univer = new ArrayList<>();
		try {
			univer.add(new Student("Ivan", format.parse("22.07.1990")));
			univer.add(new Student("Fedor", format.parse("22.03.1991")));
			univer.add(new Student("Vovan", format.parse("19.01.1989")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		File file = new File("univer.txt");
		if(!file.exists()){
            try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		Menu(univer, file, format);

	}

	public static void Menu(ArrayList<Student> univer, File file, SimpleDateFormat format) {
		while (true) {
			System.out.println("1 - Записать");
			System.out.println("2 - Прочитать");
			System.out.println("0 - Выход");

			int selection = -1;
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				selection = sc.nextInt();
			} else {
				System.out.println("Permission incorrect value");
			}

			switch (selection) {
			case 1:
				WriteArrayToFile(file, univer, format);
				break;
			case 2:
				ReadArrayOfFile(file, format);
				break;
			case 0:
				return;
			}
		}
	}

	public static void WriteArrayToFile(File file, ArrayList<Student> univer, SimpleDateFormat format) {
		try {
			FileWriter writer = new FileWriter(file);
			
			for(int i = 0; i < univer.size(); i++){
				writer.write(univer.get(i).getName());
				writer.write('\t');	
				writer.write(format.format(univer.get(i).getDate()));	
				writer.write('\n');	
				writer.flush();
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ReadArrayOfFile(File file, SimpleDateFormat format) {
		char[] buffer = new char[(int) file.length()];
		ArrayList<Student> univer2 = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader(file);
			try {
				reader.read(buffer);
				reader.close();
				String stringBuffer = new String(buffer);
				String[] arrayStringBufer = stringBuffer.split("[\n|\t]");
				
				for(int i = 0; i< arrayStringBufer.length-1; i++){
					try {
						univer2.add(new Student(arrayStringBufer[i], format.parse(arrayStringBufer[i+1])));
						i++;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(univer2.toString());
	}
}
