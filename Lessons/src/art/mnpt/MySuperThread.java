package art.mnpt;

public class MySuperThread extends Thread{
	
	private String mName;
	
	public MySuperThread(String name) {
		mName = name;
	}

	@Override
	public void run() {
		//всё что тут, будет запущено в другом потоке
		for(long i = 0; i<10; i++){
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
			
			}
			System.out.print(mName);
			
			if(isInterrupted()){
				break;
			}
		}
	}
	
	public void finish(){
		interrupt();
	}
	

}
