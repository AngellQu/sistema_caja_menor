package Persistencia.DAOs;

import java.sql.*;

import DTOs.RetiroDTO;
import Persistencia.ConexionMySql;

public class RetiroDAO implements GenericsDAO<RetiroDTO> {
	private ConexionMySql conexion = new ConexionMySql();

	@Override
	public Integer insertar(RetiroDTO dto) {
		String sql = "call insertar_retiro(?,?,?,?)";
		try (Connection conn = conexion.getConn(); 
			CallableStatement stm = conn.prepareCall(sql);) {
			stm.setInt(1, dto.getIdRetirante());
			stm.setInt(2, dto.getIdRecepcionista());
			stm.setString(3, dto.getDescripcion());
			stm.setInt(4, dto.getMonto());
			ResultSet resultado = stm.executeQuery();
			resultado.next();
			return resultado.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer eliminar(RetiroDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void consultar(RetiroDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(RetiroDTO dto) {
		// TODO Auto-generated method stub

	}

}
