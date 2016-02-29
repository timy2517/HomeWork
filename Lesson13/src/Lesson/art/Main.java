package Lesson.art;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Main {
	
	private static final String LINK = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

	public static void main(String[] args) {
		
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		try{
			URL url = new URL(LINK);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			int responseCode = httpURLConnection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK){
				
				inputStream = httpURLConnection.getInputStream();
				File file = new File("ex.xml");
				outputStream = new FileOutputStream(file);
				
				int byteRead = -1;
				byte[] buffer = new byte[512];
				while((byteRead = inputStream.read(buffer)) != -1){
					System.out.println("byteRead = " + byteRead);
					outputStream.write(buffer, 0, byteRead);
				}
				
			}else{
				System.out.println("ERROR = " + responseCode);
			}
			
		}catch(Exception e){
			System.out.println("ERROR = " + e.getMessage());
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println("inputStream ERROR = " + e.getMessage());
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				System.out.println("outputStream ERROR = " + e.getMessage());
			}
		}

	}

}
