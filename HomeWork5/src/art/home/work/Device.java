package art.home.work;

public abstract class Device {
	
	protected int operatingVoltage;
	public int getOperatingVoltage() {
		return operatingVoltage;
	}
	public void setOperatingVoltage(int operatingVoltage) {
		this.operatingVoltage = operatingVoltage;
	}
	protected boolean pluggedIn;
	
	public boolean isPluggedIn() {
		return pluggedIn;
	}
	public void setPluggedIn(boolean pluggedIn) {
		this.pluggedIn = pluggedIn;
	}
	public abstract void enableDevice();
	public abstract void disableDevice();

}
