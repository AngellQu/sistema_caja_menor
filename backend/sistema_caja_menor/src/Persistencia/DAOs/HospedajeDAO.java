package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class HospedajeDAO implements GenericsDAO {
	private ConexionMySql conn = new ConexionMySql();
	private Integer idHospedaje;
	private Integer idHuesped;
	private Integer habitacion;
	private String fechaIngreso;
	private String fechaSalida;

	@JsonCreator
	public HospedajeDAO(@JsonProperty("idHospedaje") Integer idHospedaje, @JsonProperty("idHuesped") Integer idHuesped,
			@JsonProperty("habitacion") Integer habitacion, @JsonProperty("fechaIngreso") String fechaIngreso,
			@JsonProperty("fechaSalida") String fechaSalida) {
		this.idHospedaje = idHospedaje;
		this.idHuesped = idHuesped;
		this.habitacion = habitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	@Override
	public List<Map<String, Object>> insertar() throws SQLException {
		String sql = "insert into hospedaje(id_huesped, habitacion, fecha_ingreso, fecha_salida) values (?, ?, ?, ?)";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setInt(2, habitacion);
			stm.setString(3, fechaIngreso);
			stm.setString(4, fechaSalida);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> eliminar() throws SQLException {
		String sql = "delete from hospedaje where id_huesped = ? and fecha_ingreso = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setString(2, fechaIngreso);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> consultar() throws SQLException {
		String sql = "select * from hospedaje where id_huesped = ? or fecha_ingreso = ?";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setString(2, fechaIngreso);
			return GenericsDAO.resultado(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> actualizar() throws SQLException{
		String sql = "update hospedaje set habitacion = ?, fecha_ingreso = ?, fecha_salida = ? where id = ? ";
		try (Connection conexion = conn.getConn(); PreparedStatement stm = conexion.prepareStatement(sql);) {
			stm.setInt(1, habitacion);
			stm.setString(2, fechaIngreso);
			stm.setString(3, fechaSalida);
			stm.setInt(4, idHospedaje);
			return GenericsDAO.resultado(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
}
