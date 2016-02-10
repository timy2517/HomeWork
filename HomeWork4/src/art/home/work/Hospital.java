package art.home.work;

import java.util.ArrayList;

public class Hospital {
	
	ArrayList patientsList = new ArrayList();
	
	public void addPatient(Patient p){
		patientsList.add(p);
	} 
	
	public void ShowAllPatients(){
		for(int i = 0; i<patientsList.size(); i++){
			Patient p = (Patient) patientsList.get(i);
			System.out.println(p.getName() + " " + p.getSurname()+ " " + p.getAge()+ " " + p.getGender()+ " " + p.getDiagnosis()+ " " + p.getAlive());
		}
	}

}
