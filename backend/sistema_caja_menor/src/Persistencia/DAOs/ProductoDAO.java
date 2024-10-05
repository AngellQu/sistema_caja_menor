package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class ProductoDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer id;
	private String nombre;
	private Integer precio;

	@JsonCreator
	public ProductoDAO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre,
			@JsonProperty("precio") Integer precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "insert into producto values(?,?,?)";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, id);
			stm.setString(2, nombre);
			stm.setInt(3, precio);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "delete from productos where id = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, id);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from producto where id = ? or nombre = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, id);
			stm.setString(2, nombre);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		String sql = "update productos set nombre = ?, precio = ? where id = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(3, id);
			stm.setString(1, nombre);
			stm.setInt(2, precio);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

}
