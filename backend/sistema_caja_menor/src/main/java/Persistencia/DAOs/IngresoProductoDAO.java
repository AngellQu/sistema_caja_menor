package Persistencia.DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTOs.IngresoProductoDTO;
import Persistencia.ConexionMySql;

public class IngresoProductoDAO implements GenericsDAO<IngresoProductoDTO>{
	private ConexionMySql conn = new ConexionMySql();
	
	@Override
	public Integer insertar(IngresoProductoDTO dto) {
		String sql = "call insertar_ingreso_producto(?, ?, ?, ?, ?)";
		try (Connection conexion = conn.getConn(); 
			 CallableStatement stm = conexion.prepareCall(sql);) {
			stm.setString(1, dto.getNombre());
			stm.setInt(2, dto.getCantidad());
			stm.setString(3, dto.getMetodoPago());
			stm.setInt(4, dto.getIdRecepcionista());
			stm.setInt(5, dto.getIdHuesped());
			ResultSet resultado = stm.executeQuery();
			resultado.next();
			return resultado.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer eliminar(IngresoProductoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void consultar(IngresoProductoDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(IngresoProductoDTO dto) {
		// TODO Auto-generated method stub
		
	}
}
