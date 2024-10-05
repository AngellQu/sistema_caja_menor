package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class HuespedDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer cedula;
	private String nombre;
	private String telefono;

	@JsonCreator
	public HuespedDAO(@JsonProperty("cedula") Integer cedula, @JsonProperty("nombre") String nombre,
			@JsonProperty("telefono") String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "insert into huesped values(?, ?, ?)";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, telefono);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "delete from huesped where cedula =  ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from huesped where cedula = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		String sql = "update huesped set telefono = ? where cedula = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, cedula);
			stm.setString(2, telefono);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
