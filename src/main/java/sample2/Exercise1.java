package sample2;

public class Exercise1 {

	public static void main(String[] args) {
		Team development = new Team();
		development.setName("Development team");
		development.printName();

		Team ui = new Team();
		ui.setName("UI team");
		ui.printName();

		Team cloud = new Team();
		cloud.setName("Cloud team");
		cloud.printName();
	}
}
