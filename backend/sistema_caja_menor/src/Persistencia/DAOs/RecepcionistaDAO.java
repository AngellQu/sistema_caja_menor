package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class RecepcionistaDAO implements GenericsDAO {
	private ConexionMySql conexion = new ConexionMySql();
	private String nombre;
	private String correo;
	private String direccion;
	private String telefono;
	private Integer cedula;

	@JsonCreator
	public RecepcionistaDAO(@JsonProperty("nombre") String nombre, @JsonProperty("correo") String correo,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono") String telefono,
			@JsonProperty("cedula") Integer cedula) {
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cedula = cedula;
	}

	@Override
	public List<Map<String, Object>> insertar() {
		String sql = "insert into recepcionista values (?, ?, ?, ?, ?)";
		try (Connection conn = conexion.getConn(); PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, cedula);
			stm.setString(2, nombre);
			stm.setString(3, correo);
			stm.setString(4, direccion);
			stm.setString(5, telefono);
			Integer resultado = stm.executeUpdate();
//			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> eliminar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> actualizar() {
		// TODO Auto-generated method stub
		return null;
	}




}
