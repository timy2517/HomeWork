package art.www;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Car car = new Car();

		Class classO = car.getClass();

		/*
		 * try { classO = Class.forName("art.www.Car"); } catch
		 * (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		System.out.println("class name = " + Car.class.getSimpleName());
		System.out.println("class name = " + car.getClass().getName());

		int mod = classO.getModifiers();
		if (Modifier.isPublic(mod)) {
			System.out.println("is public");
		} else {
			System.out.println("is private");
		}

		Class superC = classO.getSuperclass();
		System.out.println("class name = " + superC.getSimpleName());

		Class[] classInter = classO.getInterfaces();
		for (Class infClass : classInter) {
			System.out.println("inter = " + infClass.getSimpleName());
		}
		
		Field[] fields = classO.getFields();
		for(Field f: fields){
			System.out.println("field name = " + f.getName());
			Class type = f.getType();
			System.out.println("field type = " + f.getType());
		}
		
		fields = classO.getDeclaredFields();
		for(Field f: fields){
			System.out.println("field D name = " + f.getName());
			Class type = f.getType();
			System.out.println("field D type = " + f.getType());
		}
		
		try {
			Field f = classO.getDeclaredField("name");
			f.setAccessible(true);
			String name = (String) f.get(car);
				System.out.println("field name = " + f.get(car));
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
