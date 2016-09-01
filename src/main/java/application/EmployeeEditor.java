package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeEditor {

	public static void edit(Integer code) throws IOException {
		List<String> fields = new ArrayList<>(Arrays.asList("code", "name", "joined_date"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("編集する項目を選択してください。(0: コード, 1: 名前, 2: 入社日) > ");
		Integer num = Integer.parseInt(br.readLine());

		String fieldName = null;
		if (num == 0) {
			fieldName = "コード";
		} else if (num == 1) {
			fieldName = "名前";
		} else if (num == 2) {
			fieldName = "入社日";
		}
		System.out.print(fieldName + "の編集後の値を入力してください。 > ");
		String updatedValue = br.readLine();

		EmployeeRepository.update(code, fields.get(num), updatedValue);
	}
}
