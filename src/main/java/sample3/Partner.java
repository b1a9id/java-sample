package sample3;

public class Partner {

	private String number;

	private String name;

	private String address;

	private String tel;

	public String getPartner() {
		return "会員番号 : " + this.number + ", 氏名 : " + this.name + ", 住所 : " + this.address + ", 電話番号 : " + this.tel;
	}

	public void modifyPartnerInfo(String number, String name, String address, String tel) {
		this.number = number;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
}
