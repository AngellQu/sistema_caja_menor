 package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class HospedajesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private Integer idHuesped;
	private Integer habitacion;
	private String fechaIngreso;
	private String fechaSalida;

	static {
		RegistryDataAcces.register("Hospedajes", HospedajesDAO.class);
	}

	@JsonCreator
	public HospedajesDAO(@JsonProperty("idHuesped") Integer idHuesped,
			@JsonProperty("habitacion") Integer habitacion, @JsonProperty("fechaIngreso") String fechaIngreso,
			@JsonProperty("fechaSalida") String fechaSalida) {
		this.idHuesped = idHuesped;
		this.habitacion = habitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into hospedaje(id_huesped, habitacion, fecha_ingreso, fecha_salida) values (?, ?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setInt(2, habitacion);
			stm.setString(3, fechaIngreso);
			stm.setString(4, fechaSalida);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from hospedaje order by fecha_ingreso desc limit 1";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setString(2, fechaIngreso);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from hospedaje where id_huesped = ? or fecha_ingreso = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, idHuesped);
			stm.setString(2, fechaIngreso);
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
