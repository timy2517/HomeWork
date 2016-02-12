
public class Poezd extends Transport {
	
	public Poezd(String id, int year) {
		super(id, year);
	}
	

	int carriage;

	public int getCarriage() {
		return carriage;
	}

	public void setCarriage(int carriage) {
		this.carriage = carriage;
	}

	@Override
	public String toString() {
		return "Poezd [carriage=" + carriage + ", Id()=" + getId()
				+ ", Year()=" + getYear() + "]";
	}

	@Override
	public void buildEngine() {
		// TODO Auto-generated method stub
		System.out.println("buildEngine() in poezd");
		
	}



}
