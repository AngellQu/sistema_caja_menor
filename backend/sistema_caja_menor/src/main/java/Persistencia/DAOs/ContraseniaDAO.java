package Persistencia.DAOs;
import DTOs.ContraseniaDTO;

public class ContraseniaDAO implements GenericsDAO<ContraseniaDTO> {

	public Integer insertar(ContraseniaDTO dto) {
		return dto.getId();
	}

	public Integer eliminar(ContraseniaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void consultar(ContraseniaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	public void actualizar(ContraseniaDTO dto) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
