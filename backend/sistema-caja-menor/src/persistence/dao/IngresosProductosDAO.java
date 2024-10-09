package persistence.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class IngresosProductosDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private String fecha;
	private String nombre;
	private Integer cantidad;
	private String metodoPago;
	private Integer idRecepcionista;
	private Integer idHuesped;

	static {
		RegistryDataAcces.register("IngresosProductos", IngresosProductosDAO.class);
	}

	@JsonCreator
	public IngresosProductosDAO(@JsonProperty("fecha") String fecha, @JsonProperty("nombre") String nombre,
			@JsonProperty("cantidad") Integer cantidad, @JsonProperty("metodoPago") String metodoPago,
			@JsonProperty("idRecepcionista") Integer idRecepcionista, @JsonProperty("idHuesped") Integer idHuesped) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.metodoPago = metodoPago;
		this.idRecepcionista = idRecepcionista;
		this.idHuesped = idHuesped;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "call insertar_ingreso_producto(?, ?, ?, ?, ?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setString(1, nombre);
			stm.setInt(2, cantidad);
			stm.setString(3, metodoPago);
			stm.setInt(4, idRecepcionista);
			stm.setInt(5, idHuesped);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "call eliminar_ingreso_producto(?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRecepcionista);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from ingreso_producto where id_huesped = ? or date(fecha) = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
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
