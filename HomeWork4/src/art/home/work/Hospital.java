package art.home.work;

import java.util.ArrayList;

public class Hospital {

	ArrayList patientsList = new ArrayList();

	public void addPatient(Patient p) {
		patientsList.add(p);
	}

	public void showAllPatients() { // метод вывода всех пациентов. пункт 5
		for (int i = 0; i < patientsList.size(); i++) {
			Patient p = (Patient) patientsList.get(i);
			
			showPatient(p);
		}
	}
	
	public void showPatient(Patient p) { // метод вывода всех пациентов. пункт 5
		
			System.out.print(p.getName());
			System.out.print(" " + p.getSurname());
			System.out.print(" " + p.getAge());

			if (p.getGender() == 1) {
				System.out.print(" " + Menu.MAN);
			} else
				System.out.print(" " + Menu.WOMAN);

			System.out.print(" " + p.getDiagnosis());

			if (p.getAlive()) {
				System.out.print(" alive\n");
			} else
				System.out.print(" dead\n");

		
	}

}
