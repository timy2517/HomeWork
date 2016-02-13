package art.home.work;

public class StereoSystem extends NotAutonomic {

	private int power;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public StereoSystem(int power, int operatingVoltage) {
		this.power = power;
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
