package factory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import mapping.MappingServices;
import model.RegistryDataAcces;
import model.dao.AbstractDataAcces;

public class JsonDaoFactory {

	public static AbstractDataAcces getDAO(String data) throws ClassNotFoundException, IOException {
		String resourceName = MappingServices.getTypeEntityString(data);
		return MappingServices.mappToDao(data, RegistryDataAcces.getRecord(resourceName));
	}

	public static AbstractDataAcces getDAO(Map<String, String> data) throws ClassNotFoundException, IOException {
		String resourceName = data.get("resource");
		return MappingServices.mappToDao(data, RegistryDataAcces.getRecord(resourceName));
	}
	
	public static String getJsonOutputStreamAsString(List<Map<String,Object>> data) throws IOException {
		return MappingServices.mapToJsonStream(data);
	}
	
	public static String getJsonOutputStreamAsString(Boolean data) throws IOException {
		return MappingServices.mapToJsonStream(data);
	}
}