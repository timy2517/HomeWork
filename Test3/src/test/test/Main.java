package test.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {


		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		
		SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy z H:mm a");
		String textDate = format.format(date);
		
		System.out.println(textDate);
		
		String s1;
		
		switch(date.getDate()%10){
		case 1:
			s1 = "st";
			break;
		case 2:
			s1 = "nd";
			break;
		case 3:
			s1 = "rd";
			break;
			
			default:
				s1 = "th";
				
		}
		
		System.currentTimeMillis(); //время в милисекундах с 01.01.1970
		
		System.out.println(date.getDate() + s1 + " " + textDate);
		
		Date myDate = null;
		
		try{
			myDate = format.parse("2015-09-06");
		}catch(ParseException e){
			System.out.println("формат неверный");
		}
		System.out.println(myDate);
		
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		Date dd = calendar.getTime();
		long mil = calendar.getTimeInMillis();
		
		int day = calendar.get(GregorianCalendar.DATE);
		System.out.println(day);
		
		int mon = calendar.get(GregorianCalendar.MONTH);
		System.out.println(mon+1);
		

		calendar.set(GregorianCalendar.MONTH, 2);
		
		System.out.println(calendar.getTime());
		
		calendar.add(GregorianCalendar.DATE, -50);
		
		System.out.println(calendar.getTime());
		
		//////////////////////////////////////////////////////////////////////////
		
		GregorianCalendar calendar1 = new GregorianCalendar();
		GregorianCalendar calendar2 = new GregorianCalendar();
		
		calendar2.set(GregorianCalendar.MONTH, 5);
		calendar2.set(GregorianCalendar.DATE, 29);
		
		int m = calendar2.get(GregorianCalendar.MONTH)-calendar1.get(GregorianCalendar.MONTH);
		int d = calendar2.get(GregorianCalendar.DATE)-calendar1.get(GregorianCalendar.DATE);
		
		System.out.println(m + " мес " + d + " дней");
		
		System.out.println(calendar2.getTime());
		
		///////////////////////////////////////////////////////////////////////////////
		
		Date CurrentTime = new Date();
		Date dob = calendar2.getTime();
		
		long mm = dob.getTime() - CurrentTime.getTime();
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(mm);
		
		System.out.println(mm);
		long days = TimeUnit.MILLISECONDS.toDays(mm);
		
		System.out.println(days);
		
		System.out.println(mm/60000/60/24);
		
		
		

	}
}
