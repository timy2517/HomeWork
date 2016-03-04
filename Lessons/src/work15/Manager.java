package work15;

public class Manager {

	private static Manager instance = new Manager();

	public static Manager getInstance() {
			return instance;
	}

	private Manager() {}
}
