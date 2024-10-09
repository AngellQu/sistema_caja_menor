package persistence.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class RetirosDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String fecha;
	private Integer idRetirante;
	private Integer idRecepcionista;
	private String descripcion;
	private Integer monto;

	static {
		RegistryDataAcces.register("Retiros", RetirosDAO.class);
	}

	@JsonCreator
	public RetirosDAO(@JsonProperty("idRetirante") Integer idRetirante,
			@JsonProperty("idRecepcionista") Integer idRecepcionista, @JsonProperty("descripcion") String descripcion,
			@JsonProperty("monto") Integer monto, @JsonProperty("fecha") String fecha) {
		this.idRetirante = idRetirante;
		this.idRecepcionista = idRecepcionista;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha = fecha;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call insertar_retiro(?,?,?,?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRetirante);
			stm.setInt(2, idRecepcionista);
			stm.setString(3, descripcion);
			stm.setInt(4, monto);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "call eliminar_retiro(?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRecepcionista);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from retiro where id_retirante = ? or date(fecha) = ?";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRetirante);
			stm.setString(2, fecha);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		throw new SQLException("operacion no disponible", "METHOD_NOT_ALLOWED", 405);
	}
}
