package Persistencia.DAOs;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Persistencia.ConexionMySql;

public class IngresoHospedajeDAO implements GenericsDAO {
	private ConexionMySql conexion = new ConexionMySql();
	private String metodoPago;
	private Integer monto;
	private Integer idRecepcionista;

	@JsonCreator
	public IngresoHospedajeDAO(@JsonProperty("metodoPago") String metodoPago, @JsonProperty("monto") Integer monto,
			@JsonProperty("idRecepcionista") Integer idRecepcionista) {
		this.metodoPago = metodoPago;
		this.monto = monto;
		this.idRecepcionista = idRecepcionista;
	}

	@Override
	public List<Map<String, Object>> insertar() {
		String sql = "call insertar_ingreso_hospedaje(?, ?, ?)";
		try (Connection conn = conexion.getConn(); CallableStatement stm = conn.prepareCall(sql)) {
			stm.setString(1, metodoPago);
			stm.setInt(2, monto);
			stm.setInt(3, idRecepcionista);
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
