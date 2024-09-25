package GestionMovientos;

import DTOs.DTOs;
import FabricaDAOs.FabricaDAOs;
import FabricaDAOs.FabricaDAOsGenerics;
import Persistencia.DAOs.GenericsDAO;

public class GestorRegistros implements GestionMovimientos {
	private FabricaDAOs fabricaDaos = new FabricaDAOsGenerics();

	@Override
	public Integer insertarEntidad(DTOs dto) {
		GenericsDAO<DTOs> dao = fabricaDaos.getDAO(dto.getClass().getSimpleName());
		return dao.insertar(dto);
	}

	@Override
	public Integer consultarEntidad(DTOs dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEntidad(DTOs dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEntidad(DTOs dto) {
		// TODO Auto-generated method stub
		
	}

}
