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

public class RetirantesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String id;
	private String nombre;
	private String telefono;
	private String direccion;
	
	static {
		ServiceLocator.getRegistry().register("Retirantes", RetirantesDAO.class);
	}

	@JsonCreator
	public RetirantesDAO(@JsonProperty("id") String id, @JsonProperty("nombre") String nombre,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into retirante values (?, ?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, id);
			stm.setString(2, nombre);
			stm.setString(3, telefono);
			stm.setString(4, direccion);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from retirante where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, id);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from retirante where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, id);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		String sql = "call actualizar_retirante(?,?,?,?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setObject(1, id);
			stm.setObject(2, nombre);
			stm.setObject(3, telefono);
			stm.setObject(4, direccion);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
