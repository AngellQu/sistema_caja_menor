package Persistencia.DAOs;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GenericsDAO {

	List<Map<String, Object>> insertar() throws SQLException;

	List<Map<String, Object>> eliminar() throws SQLException;

	List<Map<String, Object>> consultar() throws SQLException;

	List<Map<String, Object>> actualizar() throws SQLException;

	static List<Map<String, Object>> resultado(Integer filas) {
		List<Map<String, Object>> resultado = new ArrayList<>();
		Map<String, Object> resultadoOperacion = new HashMap<>();
		if (filas > 0) {
			resultadoOperacion.put("resultado_operacion", "Operacion exitosa filas afectadas: " + filas);
			resultado.add(resultadoOperacion);
		} else {
			resultadoOperacion.put("resultado_operacion", "Operacion fallida no se afectaron filas");
			resultado.add(resultadoOperacion);
		}
		return resultado;
	}

	static List<Map<String, Object>> resultado(ResultSet rs) throws SQLException {
		List<Map<String, Object>> resultado = new ArrayList<>();
		if (!rs.isBeforeFirst()) {
			throw new SQLException("No se obtuvieron resultados", "NOT_FOUND", 404);
		} else {
			ResultSetMetaData metaData = rs.getMetaData();
			int numColumn = metaData.getColumnCount();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= numColumn; i++) {
					String columnName = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
				}
				resultado.add(row);
			}
		}
		return resultado;
	}
}