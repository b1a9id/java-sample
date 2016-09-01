package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeCreator {

	public void create() throws IOException {
		System.out.println("############### 社員情報を入力します。 ###############");
		System.out.print("何人登録しますか？ > ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer num = Integer.parseInt(br.readLine());

		int count = 1;
		while (count <= num) {
			System.out.println(count + "人目を入力してください。");

			try {
				System.out.print("社員コード > ");
				Integer code = Integer.parseInt(br.readLine());

				System.out.print("社員名 > ");
				String name = br.readLine();

				System.out.print("入社日(yyyy/MM/dd) > ");
				LocalDate joinedDate = LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));

				Employee employee = new Employee();
				employee.setCode(code);
				employee.setName(name);
				employee.setJoinedDate(joinedDate);
				EmployeeRepository.create(employee);

				count++;
			}
			catch (NumberFormatException e) {
				System.out.println("* 社員コードは数値で入力してください。");
				System.out.println();
			}
			catch (DateTimeParseException e) {
				System.out.println("* 入社日は yyyy/MM/dd で入力してください。");
			}
		}
	}
}
