package art.work;

public class UI implements UiInteface {

	private Button button;

	public UI() {
		// создаем объект кнопки
		button = new Button();
		// передаем ссылку на текущий класс (UI) в объект Button (в виде
		// интерфейса)
		button.setUiInterface(this);
	}

	// метод для симуляции клика на кнопку, в реальности его не будет
	public void emulateClic() {
		button.onClick();

	}

	// реализация метода из интерфейса
	@Override
	public void printData(String data) {
		System.out.println(data);

	}

}
