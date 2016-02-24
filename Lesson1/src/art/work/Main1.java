package art.work;

public class Main1 {

	public static void main(String[] args) {
		try {
			test(5, 0);
		} catch (Exception e) {
			System.out.println("FATAL ERROR ");
			System.out.println("Format C ... ");
		}

	}

	public static int test(int a, int b) throws ArithmeticException, Exception {
		
		if(a == 0 || b == 0){
			throw new ArithmeticException();
		}
		
		return a / b;
	}

}
