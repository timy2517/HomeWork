package art.work;

public class UI implements OnButtonClickListener {

	private Button button;

	public UI() {
		// создаем объект кнопки
		button = new Button();
		// передаем ссылку на текущий класс (UI) в объект Button (в виде
		// интерфейса)
		button.setOnClickListener(this);
	}

	// метод для симуляции клика на кнопку, в реальности его не будет
	public void emulateClic() {
		button.emulateClick();

	}

	// реализация метода из интерфейса
	@Override
	public void onClick() {
		System.out.println("Сработал клик");

	}

}
