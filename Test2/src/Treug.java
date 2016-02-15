public class Treug implements Figure {

	int h;
	int a;

	public Treug(int a, int h) {
		this.a = a;
		this.h = h;
	}

	@Override
	public int area() {
		int s = (a / 2) * h;
		return s;
	}

}
