package persistence.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class RegistryDataAcces {

	private static Map<String, Class<? extends AbstractDataAcces>> records = new HashMap<>();

	protected static void register(String type, Class<? extends AbstractDataAcces> daoClass) {
		records.put(type, daoClass);
	}

	public static Class<? extends AbstractDataAcces> getRegistry(String type) {
		return records.get(type);
	}
}
