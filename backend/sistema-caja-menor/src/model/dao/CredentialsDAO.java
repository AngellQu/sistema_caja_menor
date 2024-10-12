package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.MySqlConnection;
import model.ServiceLocator;

public class CredentialsDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String cedula;
	private String contrasenia;

	@JsonCreator
	public CredentialsDAO(@JsonProperty("cedula") String cedula, @JsonProperty("contrasenia") String contrasenia) {
		this.cedula = cedula;
		this.contrasenia = contrasenia;
	}

	static {
		ServiceLocator.getRegistry().register("Credentials", CredentialsDAO.class);
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call obtener_usuario_hash(?)";
		try (CallableStatement stm = conn.prepareCall(sql)) {
			stm.setString(1, cedula);
			String result = stm.executeQuery().getString(1);
			return ServiceLocator.getSecurity().VerifyUserAuthorization(result, cedula, contrasenia);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}
}
