package movement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import factory.DaoFactory;
import mapping.MappingServices;
import model.dao.AbstractDataAcces;
import security.SecurityManager;

public class MovementManager {

	public static String insert(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		if (verifySession() || (data.contains("Recepcionistas") || data.contains("Credentials"))) {
			SecurityManager.setToken(token);
			return MappingServices.mapToJsonStream(getDAO(data).insert());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String delete(Map<String, String> data, String token)
			throws SQLException, ClassNotFoundException, IOException {
		if (verifySession()) {
			SecurityManager.setToken(token);
			return MappingServices.mapToJsonStream(getDAO(data).delete());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String query(Map<String, String> data, String token)
			throws SQLException, ClassNotFoundException, IOException {
		if (verifySession()) {
			SecurityManager.setToken(token);
			return MappingServices.mapToJsonStream(getDAO(data).query());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	public static String update(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		if (verifySession()) {
			SecurityManager.setToken(token);
			return MappingServices.mapToJsonStream(getDAO(data).update());
		} else {
			throw new SQLException("sesion caducada", "UNAUTHORIZED", 401);
		}
	}

	private static AbstractDataAcces getDAO(String data) throws ClassNotFoundException, IOException {
		return DaoFactory.getDAO(data);
	}

	private static AbstractDataAcces getDAO(Map<String, String> data) throws ClassNotFoundException, IOException {
		return DaoFactory.getDAO(data);
	}

	private static Boolean verifySession() throws ClassNotFoundException {
		return SecurityManager.isthereASessionActivated();
	}
}
