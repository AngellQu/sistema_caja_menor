package mapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import persistence.dao.AbstractDataAcces;

public class MappingServices {
	private static ObjectMapper mapper = new ObjectMapper();

	public static AbstractDataAcces mappToDao(String data, Class<? extends AbstractDataAcces> dao)
			throws IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AbstractDataAcces result;
		result = mapper.readValue(data, dao);
		return result;
	}
	
	public static AbstractDataAcces mappToDao(Map<String, String> data, Class<? extends AbstractDataAcces> dao)
			throws IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AbstractDataAcces result;
		result = mapper.convertValue(data, dao);
		return result;
	}

	public static String mapToJsonStream(List<Map<String, Object>> data) throws IOException {
		return mapper.writeValueAsString(data);
	}

	public static String mapToJsonStream(Boolean data) throws IOException {
		return mapper.writeValueAsString(data);
	}
	
	public static String getTypeEntityString(String data) {
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(data);
			String tipoEntidad = jsonNode.get("resource").asText();
			return tipoEntidad;
		} catch (IOException e) {
			e.printStackTrace();
			return "tipo entidad no encontrada";
		}
	}
}
