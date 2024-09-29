package Persistencia;

import java.sql.*;

public class ConexionMySql {
	private Connection conn;

	public Connection getConn() {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_caja_menor", "root","*****");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
