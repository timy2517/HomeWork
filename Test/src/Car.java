
public class Car extends Transport{
	
	private String model;
	
	//public Car(){
	//	System.out.println("конструктор");
	//}


	public String getModel() {
		return model;
	}
	public Car(String id, String model, int year) {
		super(id, year);
		this.model = model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", Id = " + getId() + ", Year = "
				+ getYear() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
	
}
