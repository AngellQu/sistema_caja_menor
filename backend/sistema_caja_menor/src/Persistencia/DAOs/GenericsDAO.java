 package Persistencia.DAOs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GenericsDAO {

	List<Map<String, Object>> insertar();

	List<Map<String, Object>> eliminar();

	List<Map<String, Object>> consultar();

	List<Map<String, Object>> actualizar();

	static List<Map<String, Object>> resultado(ResultSet rs) {
		List<Map<String, Object>> resultado = new ArrayList<>();
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int numColumn = metaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= numColumn; i++) {
					Map<String, Object> row = new HashMap<>();
					String columnName = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
					resultado.add(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}