package art.home.work;

public class Human {
	
	private String name;
	private String surname;
	private String patronymic;
	
	public Human(String name, String surname, String patronymic){
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
	}
	
	@Override
	public String toString() {
		return name + " " + surname + " " + patronymic;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

}
