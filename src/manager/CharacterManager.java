package manager;
import java.sql.*;

public class CharacterManager{
	private Connection conn;
	private Statement stmt;
	
	public CharacterManager(){
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/projekt");
			stmt = conn.createStatement();
			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Character".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists) stmt.executeUpdate("CREATE TABLE Character(id int GENERATED BY DEFAULT AS IDENTITY, nick varchar(30), characterClass varchar(20), characterRace varchar(20), level int)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}
	
	
	
}
