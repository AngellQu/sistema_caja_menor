package Persistencia.DAOs;

import DTOs.DTOs;

public interface GenericsDAO<T> extends DAOs<DTOs>{

	public abstract Integer insertar(T dto);

	public abstract Integer eliminar(T dto);

	public abstract void consultar(T dto);

	public abstract void actualizar(T dto);
	
}