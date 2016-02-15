import java.awt.geom.Area;
import java.util.Random;

public class Main implements myTest{

	public static void main(String[] args) {

		Main main = new Main();
		test(main);

	}
	
	public static void test(myTest test){
		test.methodOne();
		test.methodTwo();
	}

	@Override
	public void methodOne() {
		System.out.println("One");
		
	}

	@Override
	public void methodTwo() {
		System.out.println("Two");
		
	}
	

}
