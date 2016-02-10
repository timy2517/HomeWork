
public class Airplane extends Transport {
	
	public Airplane(String id, int year) {
		super(id, year);
		// TODO Auto-generated constructor stub
	}

	int distance;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Airplane [distance=" + distance + ", Id()=" + getId()
				+ ", Year()=" + getYear() + "]";
	}


}
