package Persistencia;

import java.sql.*;

public class ConexionMySql {
	private Connection conn;

	public Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_caja_menor", "root", "*****");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
