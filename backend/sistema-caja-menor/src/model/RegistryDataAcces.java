package model;

import java.util.HashMap;
import java.util.Map;

import model.dao.AbstractDataAcces;

public class RegistryDataAcces {

	private static Map<String, Class<? extends AbstractDataAcces>> records = new HashMap<>();

	public void register(String type, Class<? extends AbstractDataAcces> daoClass) {
		records.put(type, daoClass);
	}

	public static Class<? extends AbstractDataAcces> getRecord(String type) {
		return records.get(type);
	}
}
