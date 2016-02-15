package art.work2.work;

public class Main {

	public static void main(String[] args) {
		
		Cellphone cellphone = new Cellphone(2012, 1.5, 24, 220);
		
		StereoSystem stereoSystem = new StereoSystem(500, 220);
		
		Televisor tele = new Televisor(25, 220);
		
		stereoSystem.enableDevice();
		tele.enableDevice();

	}

}
