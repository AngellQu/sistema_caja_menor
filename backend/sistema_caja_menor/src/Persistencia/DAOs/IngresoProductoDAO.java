package Persistencia.DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
	public  List<Map<String, Object>> insertar() {
		String sql = "call insertar_ingreso_producto(?, ?, ?, ?, ?)";
		ResultSet resultado;
		try (Connection conexion = conn.getConn(); CallableStatement stm = conexion.prepareCall(sql);) {
			stm.setString(1, nombre);
			stm.setInt(2, cantidad);
			stm.setString(3, metodoPago);
			stm.setInt(4, idRecepcionista);
			stm.setInt(5, idHuesped);
			resultado = stm.executeQuery();
			return GenericsDAO.resultado(resultado);
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
