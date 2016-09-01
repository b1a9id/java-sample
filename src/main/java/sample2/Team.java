package sample2;

public class Team {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void printName() {
		System.out.println("チーム名は、" + getName() + "です！");
	}
}
