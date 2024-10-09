package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class ContraseniasDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private Integer id;
	private String digito;

	static {
		RegistryDataAcces.register("Contrasenias", ContraseniasDAO.class);
	}

	@JsonCreator
	public ContraseniasDAO(@JsonProperty("id") Integer id, @JsonProperty("digito") String digito) {
		this.id = id;
		this.digito = digito;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
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
		String sql = "update contrasenia set digito = ? where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, digito);
			stm.setInt(2, id);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
