package art.home.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWorker {
	public static void write(String fileName, String text) {

	    File file = new File(fileName);
	 
	    try {

	        if(!file.exists()){
	            file.createNewFile();
	        }
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {

	            out.print(text);
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	 
	    }
	}
	public static String read(String fileName) throws FileNotFoundException {
	    StringBuilder sb = new StringBuilder();
	    
	    File file = new File(fileName);
	 
	    exists(fileName);
	 
	    try {
	        //Объект для чтения файла в буфер
	        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	        try {
	            //В цикле построчно считываем файл
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    //Возвращаем полученный текст с файла
	    return sb.toString();
	}
	private static void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}

}
