import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choose;

		do {
			showMenu();
			choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				showCar();
				break;
			case 2:
				insertCar();
				break;
			case 3:
				updateCar();
				break;
			case 4:
				deleteCar();
				break;
			case 5:
				findMaxPrice();
				break;
			case 6:
				System.out.println("Exit!!!");
				break;
			default:
				System.out.println("Failed!!!");
				break;
			}
		} while (choose != 6);
	}

	static void showMenu() {
		System.out.println("1. Show Cars list");
		System.out.println("2. Insert");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Find Max Price");
		System.out.println("6. Exit");
		System.out.println("Choose: ");
	}

	private static void showCar() {
		// Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
		Connection conn = null;
		Statement statement = null;
		try {
			// B1. Tạo kết nối tới CSDL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_management", "root", "vietdai123");

			// B2. Tạo 1 truy vấn tới CSDL
			// B2.1: Viết 1 lệnh sql lấy danh sách car
			String sql = "select * from car";
			// B2.2: Viết API Java Trúy vấn CSDL
			statement = conn.createStatement();
			// B2.4: Lấy dữ liệu từ CSDL ra
			ResultSet resultSet = statement.executeQuery(sql);
			// B2.5: Đọc dữ liệu từ ResultSet => convert thành các object trong Java
			while (resultSet.next()) {
				Car std = new Car(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("color"),
						resultSet.getString("type"), resultSet.getInt("yearOfManufacture"), resultSet.getLong("price"),
						resultSet.getInt("amount"));
				std.display();
			}
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			// B3. Close connection
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// Finish Show Car
	}

	private static void insertCar() {
		Car car = new Car();
		car.input();

		// Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			// B1. Tạo kết nối tới CSDL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_management", "root", "vietdai123");
			System.out.println("success");
			// B2. Tạo 1 truy vấn tới CSDL
			// B2.1: Viết 1 lệnh sql lấy danh sách ô tô
			String sql = "insert into car(id, name, color, type, yearOfManufacture, price, amount)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			// B2.2: Viết API Java Trúy vấn CSDL
			statement = conn.prepareCall(sql);
			statement.setInt(1, car.getId());
			statement.setString(2, car.getName());
			statement.setString(3, car.getColor());
			statement.setString(4, car.getType());
			statement.setInt(5, car.getYearOfManufacture());
			statement.setLong(6, car.getPrice());
			statement.setInt(7, car.getAmount());
			// B2.4: Lấy dữ liệu từ CSDL ra
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			// B3. Close connection
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// Finish Show Students
	}

	private static void updateCar() {
		System.out.println("Sửa thông tin xe theo mã");
		Car car = new Car();
		car.input();

		// Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			// B1. Tạo kết nối tới CSDL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_management", "root", "vietdai123");

			// B2. Tạo 1 truy vấn tới CSDL
			// B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
			String sql = "update student set name = ? color = ?, type = ?, yearOfManufacture = ?, price = ?, amount = ?"
					+ " where id = ?";
			// B2.2: Viết API Java Trúy vấn CSDL
			statement = conn.prepareCall(sql);
			statement.setString(1, car.getName());
			statement.setString(2, car.getColor());
			statement.setString(3, car.getType());
			statement.setInt(4, car.getYearOfManufacture());
			statement.setLong(5, car.getPrice());
			statement.setInt(6, car.getAmount());
			// B2.4: Lấy dữ liệu từ CSDL ra
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			// B3. Close connection
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// Finish Show Students
	}

	private static void deleteCar() {
		System.out.println("Enter name delete: ");
		String rollNo = sc.nextLine();

		// Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			// B1. Tạo kết nối tới CSDL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");

			// B2. Tạo 1 truy vấn tới CSDL
			// B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
			String sql = "delete from car where rollno = ?";
			// B2.2: Viết API Java Trúy vấn CSDL
			statement = conn.prepareCall(sql);
			statement.setString(1, rollNo);
			// B2.4: Lấy dữ liệu từ CSDL ra
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			// B3. Close connection
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// Finish Show Students
	}

	private static void findMaxPrice() {
		System.out.println("Nhap sinh vien can tim kiem: ");
		String name = sc.nextLine();

		// Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			// B1. Tạo kết nối tới CSDL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");

			// B2. Tạo 1 truy vấn tới CSDL
			// B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
			String sql = "select * from car where name like ?";
			// B2.2: Viết API Java Trúy vấn CSDL
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			// B2.4: Lấy dữ liệu từ CSDL ra
			ResultSet resultSet = statement.executeQuery();
			// B2.5: Đọc dữ liệu từ ResultSet => convert thành cacs object trong Java
			while (resultSet.next()) {
				Car std = new Car(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("color"),
						resultSet.getString("type"), resultSet.getInt("yearOfManufacture"), resultSet.getLong("price"),
						resultSet.getInt("amount"));
				std.display();
			}
		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			// B3. Close connection
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// Finish Show Students
	}
}
