package Persistencia.DAOs;
import java.sql.*;

import DTOs.RecepcionistaDTO;
import Persistencia.ConexionMySql;

public class RecepcionistaDAO implements GenericsDAO<RecepcionistaDTO> {
	private ConexionMySql conexion = new ConexionMySql();

	@Override
	public Integer insertar(RecepcionistaDTO dto) {
	    String sql = "insert into recepcionista values (?, ?, ?, ?, ?)";
	    try(Connection conn = conexion.getConn();
			PreparedStatement stm = conn.prepareStatement(sql)){
	    	stm.setInt(1, dto.getCedula());
		    stm.setString(2, dto.getNombre());
		    stm.setString(3, dto.getCorreo());
		    stm.setString(4, dto.getDireccion());
		    stm.setString(5, dto.getTelefono());
		    Integer resultado = stm.executeUpdate();
		    return resultado;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer eliminar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void consultar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		
	}
	     
	
}
