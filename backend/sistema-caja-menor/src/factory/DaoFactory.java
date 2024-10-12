package factory;

import java.io.IOException;
import java.util.Map;

import mapping.MappingServices;
import model.RegistryDataAcces;
import model.dao.AbstractDataAcces;

public class DaoFactory {

	public static AbstractDataAcces getDAO(String data) throws ClassNotFoundException, IOException {
		String typeName = MappingServices.getTypeEntityString(data);
		initClassForName(typeName);
		return MappingServices.mappToDao(data, getDaoClass(typeName));
	}
	
	public static AbstractDataAcces getDAO(Map<String, String> data) throws ClassNotFoundException, IOException {
		String typeName = data.get("resource");
		initClassForName(typeName);
		return MappingServices.mappToDao(data, getDaoClass(typeName));
	}

	private static Class<? extends AbstractDataAcces> getDaoClass(String entidad) {
		return RegistryDataAcces.getRegistry(entidad);
	}

	private static void initClassForName(String entidad) throws ClassNotFoundException {
		String pathClass = "persistence.dao." + entidad + "DAO";
		Class.forName(pathClass);
	}
}