package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.MySqlConnection;
import model.ServiceLocator;

public class HuespedesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String cedula;
	private String nombre;
	private String telefono;

	static {
		ServiceLocator.getRegistry().register("Huespedes", HuespedesDAO.class);
	}

	@JsonCreator
	public HuespedesDAO(@JsonProperty("cedula") String cedula, @JsonProperty("nombre") String nombre,
			@JsonProperty("telefono") String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into huesped values(?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, telefono);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from huesped where cedula =  ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, cedula);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from huesped where cedula = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, cedula);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		String sql = "call actualizar_huesped(?,?,?)";
		try (CallableStatement stm = conn.prepareCall(sql)) {
			stm.setObject(1, cedula);
			stm.setObject(2, nombre);
			stm.setObject(3, telefono);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
