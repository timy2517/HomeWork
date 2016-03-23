package art.home.work.parsing;

import art.home.work.models.Root;

abstract class ParserDownloader extends Thread {
	
	
	protected abstract  void parsing();
	
	protected boolean busy = false;
	
	Root root = new Root();
	
	boolean needUpdate = false;
	boolean isRunning = true;

	public void run() {
		
		while (true)
		{
			if (needUpdate)
			{
				System.out.println("Загрузка файла");
				parsing();
				System.out.println("Файл загружен");
				needUpdate=false;
				setBusy(false);				
			}
			
			
			try {
				super.sleep(1000);
			} catch (InterruptedException e) {
				// завершение потока
			}
		}
		
	}
	public void updateFile() {
		setBusy(true);
		needUpdate=true;
	}
	
	
	public void setRoot(Root root) {
		this.root=root;
	}
	public Root getRoot() {
		return root;
	}
	
	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void stop0()
	{
		isRunning = false;
	}

}
