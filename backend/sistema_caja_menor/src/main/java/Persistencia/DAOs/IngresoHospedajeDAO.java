package Persistencia.DAOs;
import java.sql.*;

import DTOs.IngresoHospedajeDTO;
import Persistencia.ConexionMySql;

public class IngresoHospedajeDAO implements GenericsDAO<IngresoHospedajeDTO>{
	private ConexionMySql conexion = new ConexionMySql();


	@Override
	public Integer insertar(IngresoHospedajeDTO dto) {
	    String sql = "call insertar_ingreso_hospedaje(?, ?, ?)";
	    try(Connection conn = conexion.getConn();
			CallableStatement stm = conn.prepareCall(sql)){
	    	stm.setString(1, dto.getMetodoPago());
		    stm.setInt(2, dto.getMonto());
		    stm.setInt(3, dto.getIdRecepcionista());
		    ResultSet resultado = stm.executeQuery();
		    resultado.next();
		    return resultado.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return null;
	}

	@Override
	public Integer eliminar(IngresoHospedajeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void consultar(IngresoHospedajeDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(IngresoHospedajeDTO dto) {
		// TODO Auto-generated method stub
		
	}
}
