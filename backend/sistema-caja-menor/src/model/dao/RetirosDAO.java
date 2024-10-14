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

public class RetirosDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String fecha;
	private String idRetirante;
	private String idRecepcionista;
	private String descripcion;
	private Integer monto;

	static {
		ServiceLocator.getRegistry().register("Retiros", RetirosDAO.class);
	}

	@JsonCreator
	public RetirosDAO(@JsonProperty("idRetirante") String idRetirante, @JsonProperty("descripcion") String descripcion,
			@JsonProperty("monto") Integer monto, @JsonProperty("fecha") String fecha) {
		this.idRetirante = idRetirante;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha = fecha;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call insertar_retiro(?,?,?,?)";
		idRecepcionista = ServiceLocator.getSecurity().getIdUserFromToken();
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setString(1, idRetirante);
			stm.setString(2, idRecepcionista);
			stm.setString(3, descripcion);
			stm.setInt(4, monto);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "call eliminar_retiro(?)";
		idRecepcionista = ServiceLocator.getSecurity().getIdUserFromToken();
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setString(1, idRecepcionista);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from retiro where id_retirante = ? or date(fecha) = ?";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setString(1, idRetirante);
			stm.setString(2, fecha);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}
}
