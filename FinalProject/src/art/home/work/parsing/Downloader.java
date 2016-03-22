package art.home.work.parsing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import art.home.work.models.Root;

abstract class Downloader {
	// ссылки на файлы
	protected static final String XML_URL = "http://kiparo.ru/t/shop.xml";
	protected static final String JSON_URL = "http://kiparo.ru/t/shop.json";
	protected static final String XML_FILE_NAME = "shop.xml";
	protected static final String JSON_FILE_NAME = "shop.xml";

	// парсинг файла и return заполненного root
	protected abstract Root parsing();

	// скачивание файла
	//параметры: ссылка на файл и имя выходного файла
	protected File downloadFile(String link, String fileName) {

		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		File file = null;

		try {
			URL url = new URL(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			int responseCode = httpURLConnection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {

				inputStream = httpURLConnection.getInputStream();
				file = new File(fileName);
				outputStream = new FileOutputStream(file);

				int byteRead = -1;
				byte[] buffer = new byte[512];
				while ((byteRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, byteRead);
				}
			} else {
				System.out.println("ERROR = " + responseCode);
			}
		} catch (Exception e) {
			System.out.println("ERROR = " + e.getMessage());
		} finally {
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
		return file;
	}
}
