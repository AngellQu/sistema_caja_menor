package persistence.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class IngresosHospedajesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String fecha;
	private Integer idHospedaje;
	private String metodoPago;
	private Integer monto;
	private Integer idRecepcionista;

	static {
		RegistryDataAcces.register("IngresosHospedajes", IngresosHospedajesDAO.class);
	}

	@JsonCreator
	public IngresosHospedajesDAO(@JsonProperty("fecha") String fecha, @JsonProperty("idHospedaje") Integer idHospedaje,
			@JsonProperty("metodoPago") String metodoPago, @JsonProperty("monto") Integer monto,
			@JsonProperty("idRecepcionista") Integer idRecepcionista) {
		this.fecha = fecha;
		this.idHospedaje = idHospedaje;
		this.metodoPago = metodoPago;
		this.monto = monto;
		this.idRecepcionista = idRecepcionista;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call insertar_ingreso_hospedaje(?, ?, ?)";
		try (CallableStatement stm = conn.prepareCall(sql)) {
			stm.setString(1, metodoPago);
			stm.setInt(2, monto);
			stm.setInt(3, idRecepcionista);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "call eliminar_ingreso_hospedaje(?)";
		try (CallableStatement stm = conn.prepareCall(sql)) {
			stm.setInt(1, idRecepcionista);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from ingreso_hospedaje where id_hospedaje = ? or date(fecha) = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHospedaje);
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
