
public class Work {
	public static void main(String[] args){
		
		Car car1 = new Car("AB23gd", "Audi", 2010);
		car1.myStatic = 5;
		
		Car car2 = new Car("AB23gdd", "BMW", 2011);
		car2.myStatic = 7;

		
		Poezd po = new Poezd("234", 1996);

		
		Airplane airp = new Airplane("d747", 2001);
		
		System.out.println(car1.toString());
		System.out.println(po.toString());
		System.out.println(airp.toString());
		System.out.println(car1.myStatic);
		System.out.println(car2.myStatic);
	}

}
