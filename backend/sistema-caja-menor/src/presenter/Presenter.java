package presenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import movement.MovementManager;

public class Presenter {

	public static String insert(String data) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.insert(data);
	}

	public static String delete(Map<String, String> data) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.delete(data);
	}

	public static String query(Map<String, String> data) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.query(data);
	}

	public static String update(String data) throws SQLException, ClassNotFoundException, IOException {
		return MovementManager.update(data);
	}
}
