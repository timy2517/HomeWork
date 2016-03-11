package art.mnpt;

public class Main {

	public static void main(String[] args) {

		MySuperThread thread = new MySuperThread(".");
		//thread.start();

		MySuperThread thread2 = new MySuperThread(".");
		thread2.start();

		
		for (long i = 0; i < 1; i++) {
			try {
				System.out.print("FORMAT C");
				Thread.sleep(999);
				thread.join();
				//thread.finish();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

	}
}
