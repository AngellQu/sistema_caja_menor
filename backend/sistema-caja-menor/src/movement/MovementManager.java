package movement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import factory.JsonDaoFactory;
import security.SecurityManager;

public class MovementManager {

	public static String insert(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		if (verifySession(token) || (data.contains("Recepcionistas") || data.contains("Credentials"))) {
			SecurityManager.setToken(token);
			return JsonDaoFactory.getJsonOutputStreamAsString(JsonDaoFactory.getDAO(data).insert());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String delete(Map<String, String> data, String token)
			throws SQLException, ClassNotFoundException, IOException {
		if (verifySession(token)) {
			SecurityManager.setToken(token);
			return JsonDaoFactory.getJsonOutputStreamAsString(JsonDaoFactory.getDAO(data).delete());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String query(Map<String, String> data, String token)
			throws SQLException, ClassNotFoundException, IOException {
		if (verifySession(token)) {
			SecurityManager.setToken(token);
			return JsonDaoFactory.getJsonOutputStreamAsString(JsonDaoFactory.getDAO(data).query());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String update(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		if (verifySession(token)) {
			SecurityManager.setToken(token);
			return JsonDaoFactory.getJsonOutputStreamAsString(JsonDaoFactory.getDAO(data).update());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	private static Boolean verifySession(String token) throws ClassNotFoundException {
		if (token != null) {
			return SecurityManager.isthereASessionActivated(token);
		}else {
			return false;
		}
	}
}
