package art.home.work;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Hospital hospital = new Hospital();

	public void mainMenu() {

		String mainMenu = "1 - New Patient\n2 - Change Patient\n3 - Find Patient\n4 - Delete Patient\n5 - Show all patients\nSelect: ";
		System.out.println(mainMenu);
		switch (scanPunktOfMenu()) {
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
		}

	}

	private int deletePatient() { // метод удаления пациента. пункт 4

		int i = findPatient();
		if (i != -1) {
			System.out.println("Remove this patient? (1 - remove / 2 - cancel) ");
			int x = scanPunktOfMenu();

			if (x == 1) {
				hospital.patientsList.remove(i);
				System.out.println("Patient removed ");
				mainMenu();
				return 0;
			}
			if (x == 2) {
				mainMenu();
				return 0;
			}

		} else
			mainMenu();
		return 0;

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
					System.out.println(p.getName() + " " + p.getSurname() + " " + p.getAge() + " " + p.getGender() + " "
							+ p.getDiagnosis() + " " + p.getAlive());

					return i; // действия в случае совпадения полей "Name" и
								// "Surname" у разных пациентов НЕ реализованы
				}

			}
		}
		System.out.println("Patient not found");
		mainMenu();
		return -1;
	}

	private void changePatient() { // метод изменения пациента. пункт 2

		int i = findPatient();
		while (true) {

			System.out.println("What needs to change?");
			System.out.println("1 - Name\n2 - Surname\n3 - Age\n4 - The patient died\n5 - Main menu");

			switch (scanPunktOfMenu()) {
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
				((Patient) hospital.patientsList.get(i)).setAge(scanPunktOfMenu());
				break;
			case 4:
				((Patient) hospital.patientsList.get(i)).setAlive(!((Patient) hospital.patientsList.get(i)).getAlive());
				break;
			case 5:
				mainMenu();
				break;
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
