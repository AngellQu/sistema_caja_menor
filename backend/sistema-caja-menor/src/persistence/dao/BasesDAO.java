package persistence.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class BasesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private Integer saldo;

	static {
		RegistryDataAcces.register("Bases", BasesDAO.class);
	}

	@JsonCreator
	public BasesDAO(@JsonProperty("saldo") Integer saldo) {
		this.saldo = saldo;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call establecer_base(?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, saldo);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from base order by fecha asc limit 1";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}
}
