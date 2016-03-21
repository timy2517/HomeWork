package art.home.work;

import java.util.List;

public class Root {

	private String name;
	private String location;
	private List<String> emails;
	private List<Goods> goods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "name=" + name + ", location=" + location + ", emails=" + emails + ", \ngoods=" + goods;
	}
}