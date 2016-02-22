package art.work;

public class Button {
	private UiInteface uiInterface;
	
	public void setUiInterface(UiInteface i){
		this.uiInterface = i;
	}
	
	//метод для симуляции клика на кнопку, в реальности его не будет
	public void onClick(){
		if (uiInterface != null){
			uiInterface.printData("Сработала кнопка");
		}
	}

}
