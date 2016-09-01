package application;

public class EmployeeDeleter {

	public static void delete(Integer code) {
		int result = EmployeeRepository.delete(code);
		if (result == 0) {
			System.out.println("削除に失敗しました。");
		} else {
			System.out.println("code : " + code + " を削除しました。");
		}
	}
}
