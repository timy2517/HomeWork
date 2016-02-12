
public class Treug extends Figure{
	
int a, h;
	
	public Treug(int a, int h){
		this.a = a;
		this.h = h;
	}

	@Override
	public int area() {
		int s = (a/2)*h;
		return s;
	}

}
