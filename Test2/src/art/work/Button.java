package art.work;

public class Button {
	private OnButtonClickListener listener;
	
	public void setOnClickListener(OnButtonClickListener listener){
		this.listener = listener;
	}
	
	//метод для симуляции клика на кнопку, в реальности его не будет
	public void emulateClick(){
		if (listener != null){
			listener.onClick();
		}
	}

}
