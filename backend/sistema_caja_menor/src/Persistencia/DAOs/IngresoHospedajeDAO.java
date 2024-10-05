package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class IngresoHospedajeDAO implements GenericsDAO {
	private ConexionMySql conexion = new ConexionMySql();
	private String fecha;
	private Integer idHospedaje;
	private String metodoPago;
	private Integer monto;
	private Integer idRecepcionista;

	@JsonCreator
	public IngresoHospedajeDAO(@JsonProperty("fecha") String fecha, @JsonProperty("idHospedaje") Integer idHospedaje,
			@JsonProperty("metodoPago") String metodoPago, @JsonProperty("monto") Integer monto,
			@JsonProperty("idRecepcionista") Integer idRecepcionista) {
		this.fecha = fecha;
		this.idHospedaje = idHospedaje;
		this.metodoPago = metodoPago;
		this.monto = monto;
		this.idRecepcionista = idRecepcionista;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "call insertar_ingreso_hospedaje(?, ?, ?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql)) {
			stm.setString(1, metodoPago);
			stm.setInt(2, monto);
			stm.setInt(3, idRecepcionista);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "call eliminar_ingreso_hospedaje(?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql)) {
			stm.setInt(1, idRecepcionista);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from ingreso_hospedaje where id_hospedaje = ? or date(fecha) = ?";
		try (Connection conn = conexion.getConn(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHospedaje);
			stm.setString(2, fecha);
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
