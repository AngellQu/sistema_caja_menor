package Persistencia.DAOs;
import DTOs.DTOs;

public interface GenericsDAO<T extends DTOs> {
	
	public Integer insertar(T dto);
	public Integer eliminar(T dto);
	public void consultar(T dto);
	public void actualizar(T dto);
}
