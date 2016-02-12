
public class Pr extends Figure{
	
	int a, b;
	
	public Pr(int a, int b){
		this.a = a;
		this.b = b;
	}

	@Override
	public int area() {
		int s = a*b;
		return s;
	}
	
	

}
