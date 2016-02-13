package art.home.work;

public class Televisor extends NotAutonomic {

	private double diagonal;

	public Televisor(double diagonal, int operatingVoltage) {
		this.operatingVoltage = operatingVoltage;
		this.setDiagonal(diagonal);
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
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
