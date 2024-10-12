package presenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import movement.MovementManager;

public class Presenter {
	
	public static String insert(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.insert(data, token);
	}

	public static String delete(Map<String, String> data, String token) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.delete(data, token);
	}

	public static String query(Map<String, String> data, String token) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.query(data, token);
	}

	public static String update(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.update(data, token);
	}
}
