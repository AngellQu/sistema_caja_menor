package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class ContraseniaDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer id;
	private String digito;

	@JsonCreator
	public ContraseniaDAO(@JsonProperty("id") Integer id, @JsonProperty("digito") String digito) {
		this.id = id;
		this.digito = digito;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		String sql = "update contrasenia set digito = ? where id = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql)) {
			stm.setString(1, digito);
			stm.setInt(2, id);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
