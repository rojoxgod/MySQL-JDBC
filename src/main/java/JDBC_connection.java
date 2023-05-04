import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_connection {

	public static void main(String[] args) throws SQLException {

		String username = "root";
		String password = "v12345V!";
		String url = "jdbc:mysql://localhost:3306/airline";

		Connection connectionDB = DriverManager.getConnection(url, username, password);

		Statement DB = connectionDB.createStatement();

		ResultSet result = DB.executeQuery("SELECT * FROM fleet WHERE manufacturer = 'Airbus' AND model = 'A320neo' AND baseLocation = 'Malpensa';");

		while (result.next()) {
			System.out.print(result.getString("id"));
			System.out.print(" ");
			System.out.print(result.getString("model"));
			System.out.print(" ");
			System.out.print(result.getString("manufacturer"));
			System.out.print(" ");
			System.out.print(result.getString("baseLocation"));
		}
		
		DB.executeUpdate("INSERT INTO fleet VALUES(id, 'Airbus', 'A380', 'Bergamo', '2023-01-01');");
		
		
	}

}
