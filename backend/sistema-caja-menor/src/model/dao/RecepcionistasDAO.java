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

public class RecepcionistasDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String nombre;
	private String cedula;
	private String correo;
	private String direccion;
	private String telefono;
	private String contrasenia;

	static {
		ServiceLocator.getRegistry().register("Recepcionistas", RecepcionistasDAO.class);
	}

	@JsonCreator
	public RecepcionistasDAO(@JsonProperty("nombre") String nombre, @JsonProperty("correo") String correo,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono,
			@JsonProperty("cedula") String cedula, @JsonProperty("contrasenia") String contrasenia) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contrasenia = ServiceLocator.getSecurity().createPasswordHash(contrasenia);
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into recepcionista values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, correo);
			stm.setString(4, direccion);
			stm.setString(5, telefono);
			stm.setString(6, contrasenia);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from recepcionista where cedula = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, cedula);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from recepcionista where cedula = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, cedula);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		String sql = "call actualizar_recepcionista(?,?,?,?,?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setObject(1, cedula);
			stm.setObject(2, nombre);
			stm.setObject(3, correo);
			stm.setObject(4, telefono);
			stm.setObject(5, direccion);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
