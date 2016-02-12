import java.util.Scanner;

public class Work {
	public static void main(String[] args) {

		Transport transport;

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		if (a == 0) {
			transport = new Car("AB23gd", "Audi", 2010);
		} else if (a == 1) {
			transport = new Poezd("AB23gd", 2010);
		} else
			transport = new Airplane("AB23gd", 2010);

		// car = new Car("AB23gd", "Audi", 2010);
		// car.myStatic = 5;

		transport.buildEngine();
	}

}
