package sample3;

public class Exercise2 {

	public static void main(String[] args) {
		Partner partner = new Partner();
		try {
			partner.modifyPartnerInfo(args[0], args[1], args[2], args[3]);
			System.out.println(partner.getPartner());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("引数がありません。");
			System.out.println("入力形式：社員番号 名前 住所 電話番号");
		}
	}
}
