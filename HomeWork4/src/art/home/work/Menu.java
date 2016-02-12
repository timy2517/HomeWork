package art.home.work;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public static final String MAN = "man";
	public static final String WOMAN = "woman";

	Hospital hospital = new Hospital();

	public void mainMenu() {

		while (true) {
			String mainMenu = "1 - New Patient\n2 - Change Patient\n3 - Find Patient\n4 - Delete Patient\n5 - Show all patients\n0 - Exit\nSelect: ";
			System.out.println(mainMenu);
			switch (scanKay()) {
			case 1:
				newPatient();
				break;
			case 2:
				changePatient();
				break;
			case 3:
				findPatient();
				break;
			case 4:
				deletePatient();
				break;
			case 5:
				hospital.showAllPatients();
				break;
			case 0:
				return;
			}
		}
	}

	private void deletePatient() { // метод удаления пациента. пункт 4

		int i = findPatient();
		if (i != -1) {
			System.out.println("Remove this patient? (1 - remove / 2 - cancel) ");
			int x = scanKay();

			if (x == 1) {
				hospital.patientsList.remove(i);
				System.out.println("Patient removed ");
				return;
			}
			if (x == 2) {
				return;
			}

		} else
			return;

	}

	private int findPatient() { // метод поиска пациента. пункт 3

		String tempName, tempSurname;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of the patient: ");
		tempName = sc.nextLine();

		System.out.println("Enter the patient's name: ");
		tempSurname = sc.nextLine();

		for (int i = 0; i < hospital.patientsList.size(); i++) {

			if (((Patient) hospital.patientsList.get(i)).getName().equals(tempName)) {
				if (((Patient) hospital.patientsList.get(i)).getSurname().equals(tempSurname)) {

					Patient p = (Patient) hospital.patientsList.get(i);
					
					hospital.showPatient(p);

					return i; // действия в случае совпадения полей "Name" и
								// "Surname" у разных пациентов НЕ реализованы
				}

			}
		}
		System.out.println("Patient not found");
		return -1;
	}

	private void changePatient() { // метод изменения пациента. пункт 2

		int i = findPatient();
		if (i == -1)
			return;
		
		while (true) {

			System.out.println("What needs to change?");
			System.out.println("1 - Name\n2 - Surname\n3 - Age\n4 - The patient died\n5 - Main menu");

			switch (scanKay()) {
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("New name: ");
				((Patient) hospital.patientsList.get(i)).setName(sc.nextLine());
				break;
			case 2:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("New surname: ");
				((Patient) hospital.patientsList.get(i)).setSurname(sc1.nextLine());
				break;
			case 3:
				System.out.println("New Age: ");
				((Patient) hospital.patientsList.get(i)).setAge(scanKay());
				break;
			case 4:
				((Patient) hospital.patientsList.get(i)).setAlive(!((Patient) hospital.patientsList.get(i)).getAlive());
				break;
			case 5:
				return;
			}
		}

	}

	private void newPatient() { // Метод создания пациента. пункт 1

		Patient newPatient = new Patient();

		Scanner sc = new Scanner(System.in);

		System.out.println("Name: ");
		newPatient.setName(sc.nextLine());

		System.out.println("Surname: ");
		newPatient.setSurname(sc.nextLine());

		System.out.println("Age: ");
		newPatient.setAge(scanKay());

		System.out.println("gender (1 - man / 0 - woman): ");
		newPatient.setGender(scanKay());

		System.out.println("Diagnosis: ");
		newPatient.setDiagnosis(sc.nextLine());

		newPatient.setAlive(true);

		hospital.addPatient(newPatient);

		// mainMenu();
	}

	private int scanKay() {

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
