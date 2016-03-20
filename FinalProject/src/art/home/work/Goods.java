package art.home.work;

import java.util.Date;

public class Goods {

	
	private int id;
	private String name;
	private String description;
	private Date year;
	private int price;
	private boolean visible;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	@Override
	public String toString() {
		return "\nGoods [id=" + id + ", name=" + name + ", description=" + description + ", year=" + year
				+ ", price=" + price + ", visible=" + visible +  "]";
	}
	
	
}