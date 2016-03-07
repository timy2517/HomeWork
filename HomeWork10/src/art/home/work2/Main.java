package art.home.work2;

import art.home.work2.Sity.Area;
import art.home.work2.Sity.Square;
import art.home.work2.Sity.Street;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sity minsk = new Sity("Minsk");
		
		Street nezavisimostyStr = minsk.new Street("Nezavisimosty");
		Area leninaPl = minsk.new Area("Lenina");
		Square kievskijSkv = minsk.new Square("Kievskij");

	}

}
