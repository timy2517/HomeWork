
public class MyException extends Exception {

	public MyException() {
		
	}
	
	public String getRussianMessage() {
		
		return super.getMessage();
	}

    String str;

	public MyException(String str) {
		
		super(str);
	}

}