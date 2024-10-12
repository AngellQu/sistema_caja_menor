package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AbstractDataAcces {

	List<Map<String, Object>> insert() throws SQLException;

	List<Map<String, Object>> delete() throws SQLException;

	List<Map<String, Object>> query() throws SQLException;

	List<Map<String, Object>> update() throws SQLException;

}