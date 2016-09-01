package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("############### メニュー ###############");
			System.out.println("1: 社員情報を入力する");
			System.out.println("2: 社員情報を編集する");
			System.out.println("3: 社員情報を削除する");
			System.out.println("4: 社員一覧を表示する");
			System.out.println("5: 社員を検索する");
			System.out.println("9: アプリを終了する");
			System.out.println("#######################################");

			System.out.print("何を行いますか？ > ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer num = Integer.parseInt(br.readLine());

			Integer code;
			switch (num) {
			case 1:
				EmployeeCreator employeeCreator = new EmployeeCreator();
				employeeCreator.create();
				System.out.println("登録が完了しました！");
				break;
			case 2:
				System.out.print("編集する社員番号を入力してください。 > ");
				code = Integer.parseInt(br.readLine());
				EmployeeEditor.edit(code);
				System.out.println("編集が完了しました！");
				break;
			case 3:
				System.out.print("削除する社員番号を入力してください。 > ");
				code = Integer.parseInt(br.readLine());
				EmployeeDeleter.delete(code);
				break;
			case 4:
				EmployeeSearcher.search(num, null);
				break;
			case 5:
				System.out.print("検索する社員番号を入力してください。 > ");
				code = Integer.parseInt(br.readLine());
				EmployeeSearcher.search(num, code);
				break;
			case 9:
				System.exit(0);
				break;
			}
		}
	}
}
