
public class Main {

	public static void main(String[] args) {

		String text = new String("Valve's considerable efforts on behalf of Linux-based gaming just aren't paying off valve and its hardware partners released the first Steam machines running the Linux-based SteamOS about four months ago. And there are now more than 1,900 games available for Linux on the Steam store. But Linux usage on Steam just keeps falling.");
		String[] arrayString = text.split(" ");
		int i = 0;
		int j = 0;

		while (true) {
			if (i == arrayString.length) {
				j++;
				i = 0;
				if (j == arrayString.length) {
					break;
				}
			}

			if (arrayString[i].length() == j + 1) {
				System.out.println(arrayString[i]);
			}
			i++;
		}

	}

}
