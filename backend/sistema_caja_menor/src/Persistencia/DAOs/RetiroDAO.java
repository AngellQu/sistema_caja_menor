package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class RetiroDAO implements GenericsDAO {
	private ConexionMySql conexion = new ConexionMySql();
	private String fecha;
	private Integer idRetirante;
	private Integer idRecepcionista;
	private String descripcion;
	private Integer monto;

	@JsonCreator
	public RetiroDAO(@JsonProperty("idRetirante") Integer idRetirante,
			@JsonProperty("idRecepcionista") Integer idRecepcionista, @JsonProperty("descripcion") String descripcion,
			@JsonProperty("monto") Integer monto, @JsonProperty("fecha") String fecha) {
		this.idRetirante = idRetirante;
		this.idRecepcionista = idRecepcionista;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha = fecha;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "call insertar_retiro(?,?,?,?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRetirante);
			stm.setInt(2, idRecepcionista);
			stm.setString(3, descripcion);
			stm.setInt(4, monto);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "call eliminar_retiro(?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRecepcionista);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from retiro where id_retirante = ? or date(fecha) = ?";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRetirante);
			stm.setString(2, fecha);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		throw new SQLException("operacion no disponible");
	}
}
