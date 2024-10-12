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
		SecurityManager.setToken(token);
		return MappingServices.mapToJsonStream(getDAO(data).insert());
	}

	public static String delete(Map<String, String> data, String token) throws SQLException, ClassNotFoundException, IOException {
		SecurityManager.setToken(token);
		return MappingServices.mapToJsonStream(getDAO(data).delete());
	}

	public static String query(Map<String, String> data, String token) throws SQLException, ClassNotFoundException, IOException {
		SecurityManager.setToken(token);
		return MappingServices.mapToJsonStream(getDAO(data).query());
	}

	public static String update(String data, String token) throws SQLException, ClassNotFoundException, IOException {
		SecurityManager.setToken(token);
		return MappingServices.mapToJsonStream(getDAO(data).update());
	}

	private static AbstractDataAcces getDAO(String data) throws ClassNotFoundException, IOException {
		return DaoFactory.getDAO(data);
	}

	private static AbstractDataAcces getDAO(Map<String, String> data) throws ClassNotFoundException, IOException {
		return DaoFactory.getDAO(data);
	}
}
