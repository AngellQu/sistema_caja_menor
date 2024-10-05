package Persistencia.DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class RetiranteDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer id;
	private String nombre;
	private String telefono;
	private String direccion;

	@JsonCreator
	public RetiranteDAO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "insert into retirante values (?, ?, ?, ?)";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.setString(2, nombre);
			stm.setString(3, telefono);
			stm.setString(4, direccion);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "delete from retirante where id = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			stm.setInt(1, id);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from retirante where id = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			stm.setInt(1, id);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		String sql = "call actualizar_retirante(?,?,?,?)";
		try (Connection conexion = conn.getConn(); CallableStatement stm = conexion.prepareCall(sql);) {
            stm.setInt(1, id);
			stm.setString(2, nombre);
			stm.setString(3, telefono);
			stm.setString(4, direccion);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

}
