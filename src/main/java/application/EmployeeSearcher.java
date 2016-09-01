package application;

import java.util.List;

public class EmployeeSearcher {

	public enum Type {
		ONE,
		ALL
	}

	public static void search(int num, Integer code) {
		List<Employee> employees = num == 4 ? EmployeeRepository.show(Type.ALL, null) : EmployeeRepository.show(Type.ONE, code);
		if (!employees.isEmpty()) {
			employees.forEach(employee -> {
				String message = "社員番号 : " + employee.getCode() + ", " + "名前 : " + employee.getName() + ", " + "入社日 : " + employee.getJoinedDate();
				System.out.println(message);
			});
		} else {
			System.out.println("社員が存在しません。");
		}
		System.out.println();
	}
}
