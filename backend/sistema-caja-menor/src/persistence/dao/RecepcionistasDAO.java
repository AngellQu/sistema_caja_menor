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

public class RecepcionistasDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String nombre;
	private Integer cedula;
	private String correo;
	private String direccion;
	private String telefono;

	static {
		RegistryDataAcces.register("Recepcionistas", RecepcionistasDAO.class);
	}

	@JsonCreator
	public RecepcionistasDAO(@JsonProperty("nombre") String nombre, @JsonProperty("correo") String correo,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono,
			@JsonProperty("cedula") Integer cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into recepcionista values (?, ?, ?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, correo);
			stm.setString(4, direccion);
			stm.setString(5, telefono);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from recepcionista where cedula = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from recepcionista where cedula = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return AbstractDataAcces.result(stm.executeQuery());
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
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
