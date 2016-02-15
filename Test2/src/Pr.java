public class Pr implements Figure {

	int b;
	int a;

	public Pr(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int area() {
		int s = a * b;
		return s;
	}

}
