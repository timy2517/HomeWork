package art.home.work;

public class Cellphone extends Autonomic {

	private int productionDate;

	public int getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(int productionDate) {
		this.productionDate = productionDate;
	}

	public Cellphone(int productionDate, double chargingTime, double batteryLife, int operatingVoltage) {

		this.chargingTime = chargingTime;
		this.batteryLife = batteryLife;
		this.productionDate = productionDate;
		this.operatingVoltage = operatingVoltage;
	}

	@Override
	public void enableDevice() {
		this.pluggedIn = true;
System.out.println("Enabled");
	}

	@Override
	public void disableDevice() {
		this.pluggedIn = false;
		System.out.println("Disabled");
	}

}
