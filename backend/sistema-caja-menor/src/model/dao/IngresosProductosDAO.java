package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.MySqlConnection;
import model.ServiceLocator;

public class IngresosProductosDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String fecha;
	private String nombre;
	private Integer cantidad;
	private String metodoPago;
	private String idRecepcionista;
	private String idHuesped;

	static {
		ServiceLocator.getRegistry().register("IngresosProductos", IngresosProductosDAO.class);
	}

	@JsonCreator
	public IngresosProductosDAO(@JsonProperty("fecha") String fecha, @JsonProperty("nombre") String nombre,
			@JsonProperty("cantidad") Integer cantidad, @JsonProperty("metodoPago") String metodoPago,
			@JsonProperty("idHuesped") String idHuesped) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.metodoPago = metodoPago;
		this.idHuesped = idHuesped;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call insertar_ingreso_producto(?, ?, ?, ?, ?)";
		idRecepcionista = ServiceLocator.getSecurity().getIdUserFromToken();
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setString(1, nombre);
			stm.setInt(2, cantidad);
			stm.setString(3, metodoPago);
			stm.setString(4, idRecepcionista);
			stm.setString(5, idHuesped);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "call eliminar_ingreso_producto(?)";
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
		String sql = "select * from ingreso_producto where id_huesped = ? or date(fecha) = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, idHuesped);
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
