package art.home.work;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	Hospital hospital = new Hospital();

	public void mainMenu() {
		
		

		String mainMenu = "1 - New Patient\n2 - Change Patient\n3 - Find Patient\n4 - Delete Patient\n5 - Show all patients\nSelect: ";
		System.out.println(mainMenu);
		switch (scanPunktOfMenu()){
		case 1:
			NewPatient();
			break;
		case 2:
			ChangePatient();
			break;
		case 3:
			FindPatient();
			break;
		case 4:
			DeletePatient();
			break;
		case 5:
			hospital.ShowAllPatients();
			break;
		}

	}
	


	private void DeletePatient() {
		// TODO Auto-generated method stub
		
	}

	private void FindPatient() {
		// TODO Auto-generated method stub
		
	}

	private void ChangePatient() {
		// TODO Auto-generated method stub
		
	}

	private void NewPatient() {
		// TODO Auto-generated method stub
		Patient newPatient = new Patient();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Name: ");
		newPatient.setName(sc.nextLine());
		
		System.out.println("Surname: ");
		newPatient.setSurname(sc.nextLine());
		
		System.out.println("Age: ");
		newPatient.setAge(scanPunktOfMenu());
		
		System.out.println("gender: ");
		newPatient.setGender(scanPunktOfMenu());
		
		System.out.println("Diagnosis: ");
		newPatient.setDiagnosis(sc.nextLine());
		
		newPatient.setAlive(true);
		
		
		hospital.addPatient(newPatient);
		
		mainMenu();
	}

	private int scanPunktOfMenu() {
		
		int x;

		while (true) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				break;
			} else {
				System.out.println("Permission incorrect value");
			}
		}
		return x;

	}
	
	
}
