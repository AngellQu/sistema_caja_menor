package model.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AbstractResultManager {

	protected static List<Map<String, Object>> result(Integer filas) {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> operationResult = new HashMap<>();
		if (filas > 0) {
			operationResult.put("resultado_operacion", "Operacion exitosa filas afectadas: " + filas);
			result.add(operationResult);
		} else {
			operationResult.put("resultado_operacion", "Operacion fallida no se afectaron filas");
			result.add(operationResult);
		}
		return result;
	}

	protected static List<Map<String, Object>> result(ResultSet rs) throws SQLException {
		List<Map<String, Object>> result = new ArrayList<>();
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
				result.add(row);
			}
		}
		return result;
	}

}
