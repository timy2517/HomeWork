
public class Kvad extends Figure{
	
	int a;
	
	public Kvad(int a){
		this.a = a; 
	}

	@Override
	public int area() {
		int s = a*a;
		return s;
	}

}
