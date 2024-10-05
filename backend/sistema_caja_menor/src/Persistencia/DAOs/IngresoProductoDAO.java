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

public class IngresoProductoDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private String nombre;
	private Integer cantidad;
	private String metodoPago;
	private Integer idRecepcionista;
	private Integer idHuesped;

	@JsonCreator
	public IngresoProductoDAO(@JsonProperty("nombre") String nombre, @JsonProperty("cantidad") Integer cantidad,
			@JsonProperty("metodoPago") String metodoPago, @JsonProperty("idRecepcionista") Integer idRecepcionista,
			@JsonProperty("idHuesped") Integer idHuesped) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.metodoPago = metodoPago;
		this.idRecepcionista = idRecepcionista;
		this.idHuesped = idHuesped;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "call insertar_ingreso_producto(?, ?, ?, ?, ?)";
		try (Connection conexion = conn.getConn(); CallableStatement stm = conexion.prepareCall(sql);) {
			stm.setString(1, nombre);
			stm.setInt(2, cantidad);
			stm.setString(3, metodoPago);
			stm.setInt(4, idRecepcionista);
			stm.setInt(5, idHuesped);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "call eliminar_ingreso_producto(?)";
		try (Connection conexion = conn.getConn(); CallableStatement stm = conexion.prepareCall(sql);) {
			stm.setInt(1, idRecepcionista);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from ingreso_producto where id_huesped = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException {
		throw new SQLException("operacion no disponible");
	}

}
