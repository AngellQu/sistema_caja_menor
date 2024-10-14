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

public class HospedajesDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private Integer id;
	private String idHuesped;
	private Integer habitacion;
	private String fechaIngreso;
	private String fechaSalida;

	static {
		ServiceLocator.getRegistry().register("Hospedajes", HospedajesDAO.class);
	}

	@JsonCreator
	public HospedajesDAO(@JsonProperty("id") Integer id, @JsonProperty("idHuesped") String idHuesped,
			@JsonProperty("habitacion") Integer habitacion, @JsonProperty("fechaIngreso") String fechaIngreso,
			@JsonProperty("fechaSalida") String fechaSalida) {
		this.id = id;
		this.idHuesped = idHuesped;
		this.habitacion = habitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into hospedaje(id_huesped, habitacion, fecha_ingreso, fecha_salida) values (?, ?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, idHuesped);
			stm.setInt(2, habitacion);
			stm.setString(3, fechaIngreso);
			stm.setString(4, fechaSalida);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from hospedaje order by fecha_ingreso desc limit 1";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, idHuesped);
			stm.setString(2, fechaIngreso);
			return AbstractResultManager.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		} 
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from hospedaje where id_huesped = ? or fecha_ingreso = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, idHuesped);
			stm.setString(2, fechaIngreso);
			return AbstractResultManager.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		String sql = "call actualizar_hospedaje(?, ?, ?, ?, ?)";
		try(CallableStatement stm = conn.prepareCall(sql)){
			stm.setObject(1, id);
			stm.setObject(2, idHuesped);
			stm.setObject(3, habitacion);
			stm.setObject(4, fechaIngreso);
			stm.setObject(5, fechaSalida);
			return AbstractResultManager.result(stm.executeUpdate());
		}catch(SQLException e){
			throw e;
		}
	}
}
