package www.gson;

import com.google.gson.annotations.SerializedName;

public class People {

	private int age;
	private long id;
	private boolean isDegree;
	
	@SerializedName("name_one") //переопределили имя
	private String name;
	
	private String surname;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isDegree() {
		return isDegree;
	}
	public void setDegree(boolean isDegree) {
		this.isDegree = isDegree;
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
	@Override
	public String toString() {
		return "People [age=" + age + ", id=" + id + ", isDegree=" + isDegree
				+ ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}