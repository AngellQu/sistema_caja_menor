package Persistencia.DAOs;
import DTOs.RecepcionistaDTO;

public class RecepcionistaDAO implements GenericsDAO<RecepcionistaDTO> {

	public Integer insertar(RecepcionistaDTO dto) {
		return dto.getCedula();
	}

	public Integer eliminar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void consultar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	public void actualizar(RecepcionistaDTO dto) {
		// TODO Auto-generated method stub
		
	}

	
}
