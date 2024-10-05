package Mapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Persistencia.DAOs.GenericsDAO;

public class Mapper implements MappingServices {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public GenericsDAO mapToDao(String entidad, Class<? extends GenericsDAO> dao) {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GenericsDAO result = null;
		try {
			result = mapper.readValue(entidad, dao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ByteArrayOutputStream mapToJsonStream(List<Map<String, Object>> entidades) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		try {
			mapper.writeValue(result, entidades);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ByteArrayOutputStream mapToJsonStream(Boolean entidades) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		try {
			mapper.writeValue(result, entidades);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getTypeEntityString(String entidad) {
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(entidad);
			String tipoEntidad = jsonNode.get("tipoEntidad").asText();
			return tipoEntidad;
		} catch (IOException e) {
			e.printStackTrace();
			return "tipo entidad no encontrada";
		}
	}
}
