package art.home.work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	
	String name;
	Date date;
	
	public Student(String name, Date date){
		this.name = name;
		this.date = date;
	}
		
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	@Override
	public String toString() {
		return "\n" + name + " " + format.format(date);
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
