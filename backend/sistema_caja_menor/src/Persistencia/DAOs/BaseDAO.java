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

public class BaseDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer saldo;

	@JsonCreator
	public BaseDAO(@JsonProperty("saldo") Integer saldo) {
		this.saldo = saldo;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException{
		String sql = "call establecer_base(?)";
		try (Connection conexion = conn.getConn(); CallableStatement stm = conexion.prepareCall(sql);) {
			stm.setInt(1, saldo);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException  {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select saldo from base order by fecha asc limit 1";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}
}
