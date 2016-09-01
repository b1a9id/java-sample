package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uchitate on 2016/08/31.
 */
public class EmployeeRepository {

	private static Connection connection = null;
	private static final String URL = "jdbc:mysql://localhost:3306/sample";
	private static final String USER = "sample";
	private static final String PASSWORD = "sample";

	public static List<Employee> show(EmployeeSearcher.Type type, Integer code) {
		String sql = type.equals(EmployeeSearcher.Type.ALL) ? "select * from employee" : "select * from employee where code = " + code;
		List<Employee> employees = search(sql);
		return employees;
	}

	public static void create(Employee employee) {
		try {
			String sql = "insert into employee (code, name, joined_date) values (?, ?, ?)";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getCode());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDate(3, Date.valueOf(employee.getJoinedDate()));
			preparedStatement.execute();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
	}

	public static void update(Integer code, String fieldName, String updatedValue) {
		try {
			String sql = "update employee set " + fieldName + " = ? where code = ?";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			if (fieldName.equals("code")) {
				preparedStatement.setInt(1, Integer.parseInt(updatedValue));
			} else if (fieldName.equals("name")) {
				preparedStatement.setString(1, updatedValue);
			} else if (fieldName.equals("joined_date")) {
				preparedStatement.setDate(1, Date.valueOf(updatedValue));
			}
			preparedStatement.setInt(2, code);
			preparedStatement.execute();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
	}

	private static List<Employee> search(String sql) {
		List<Employee> employees = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getInt("code"));
				employee.setName(resultSet.getString("name"));
				employee.setJoinedDate(resultSet.getDate("joined_date").toLocalDate());
				employees.add(employee);
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		return employees;
	}

	public static int delete(Integer code) {
		String sql = "delete from employee where code = " + code;
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate(sql);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		return result;
	}
}
