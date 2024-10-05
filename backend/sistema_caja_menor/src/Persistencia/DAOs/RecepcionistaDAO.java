package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class RecepcionistaDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private String nombre;
	private Integer cedula;
	private String correo;
	private String direccion;
	private String telefono;

	@JsonCreator
	public RecepcionistaDAO(@JsonProperty("nombre") String nombre, @JsonProperty("correo") String correo,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono,
			@JsonProperty("cedula") Integer cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "insert into recepcionista values (?, ?, ?, ?, ?)";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			stm.setInt(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, correo);
			stm.setString(4, direccion);
			stm.setString(5, telefono);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "delete from recepcionista where cedula = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from recepcionista where cedula = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		String sql = "update recepcionista set correo = ?, direccion = ?, telefono = ? where cedula = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setString(1, correo);
			stm.setString(2, direccion);
			stm.setString(3, telefono);
			stm.setInt(4, cedula);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
