package tgm.exp.testing;

//STEP 1. Import required packages
import java.sql.*;

/**
 * 
 * Hier wird mittels JDBC meine lokale INSY-Datenbank nach dem Tutorial
 * ausgelesen.
 * 
 * @author Michael Weinberger 4AHITT
 * @see http://www.tutorialspoint.com/jdbc/jdbc-quick-guide.htm
 *
 */
public class readDB {

	static final String URL = "jdbc:mysql://localhost:3306/premiere";
	static final String USER = "insy4";
	static final String PASS = "blabla";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC-Treiber wurde geladen...");
		} catch (ClassNotFoundException e) {
			System.out.println("Der JDBC-Treiber wurde nicht gefunden! "
					+ e.getMessage());
			System.exit(1);
		}

		// STEP 3: Open a connection
		// Database credentials
		System.out.println("Connecting to database...");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC-Treiber wurde geladen...");

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("DB-Verbindung aufgebaut!");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT sname FROM sender";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("sname");

				// Display values
				System.out.print(name + "\n");
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

			System.out.println("Programm wird beendet.");
			System.exit(0);

		} catch (SQLException e) {
			System.out
					.println("Es konnte keine Verbindung zur DB hergestellt werden! "
							+ e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Der JDBC-Treiber wurde nicht gefunden! "
					+ e.getMessage());
			System.exit(1);

		}
	}

}
