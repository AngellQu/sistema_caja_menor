package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class RetiroDAO implements GenericsDAO {
	private ConexionMySql conexion = new ConexionMySql();
	private Integer idRetirante;
	private Integer idRecepcionista;
	private String descripcion;
	private Integer monto;

	@JsonCreator
	public RetiroDAO(@JsonProperty("idRetirante") Integer idRetirante, @JsonProperty("idRecepcionista") Integer idRecepcionista,
			@JsonProperty("descripcion") String descripcion,
			@JsonProperty("monto")Integer monto) {
		this.idRetirante = idRetirante;
		this.idRecepcionista = idRecepcionista;
		this.descripcion = descripcion;
		this.monto = monto;
	}

	@Override
	public List<Map<String, Object>> insertar() {
		String sql = "call insertar_retiro(?,?,?,?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, idRetirante);
			stm.setInt(2, idRecepcionista);
			stm.setString(3, descripcion);
			stm.setInt(4, monto);
			ResultSet resultado = stm.executeQuery();
			resultado.next();
//			return resultado.getInt(1);
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
