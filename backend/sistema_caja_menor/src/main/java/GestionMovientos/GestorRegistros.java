package GestionMovientos;
import DTOs.DTOs;
import Persistencia.DAOs.GenericsDAO;

public class GestorRegistros {
	private GenericsDAO<DTOs> entidad;
	
	public GestorRegistros(GenericsDAO<DTOs> entidad) {
		this.entidad = entidad;
	}
	
	public Integer insertarEntidad (DTOs dto) {
		return entidad.insertar(dto);
	}
}
