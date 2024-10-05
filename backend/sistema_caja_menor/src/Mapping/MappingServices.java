package Mapping;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import Persistencia.DAOs.GenericsDAO;

public interface MappingServices {

	GenericsDAO mapToDao(String entidad, Class<? extends GenericsDAO> dao);

	ByteArrayOutputStream mapToJsonStream(List<Map<String, Object>> entidades);

	ByteArrayOutputStream mapToJsonStream(Boolean entidades);

	String getTypeEntityString(String entidad);

}
