package movement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import factory.FactoryGenericsDao;
import mapping.MappingServices;
import persistence.dao.AbstractDataAcces;

public class MovementManager {

	public static String insert(String data) throws SQLException, ClassNotFoundException, IOException {
		return MappingServices.mapToJsonStream(getDAO(data).insert());
	}

	public static String delete(Map<String, String> data) throws SQLException, ClassNotFoundException, IOException {
		return MappingServices.mapToJsonStream(getDAO(data).delete());
	}

	public static String query(Map<String, String> data) throws SQLException, ClassNotFoundException, IOException {
		return MappingServices.mapToJsonStream(getDAO(data).query());
	}

	public static String update(String data) throws SQLException, ClassNotFoundException, IOException {
		return MappingServices.mapToJsonStream(getDAO(data).update());
	}

	private static AbstractDataAcces getDAO(String data) throws ClassNotFoundException, IOException {
		return FactoryGenericsDao.getDAO(data);
	}

	private static AbstractDataAcces getDAO(Map<String, String> data) throws ClassNotFoundException, IOException {
		return FactoryGenericsDao.getDAO(data);
	}

}
