package Presentador;

import DTOs.DTOs;

public interface PresentadorInterfaz {

	public abstract Integer insertarEntidad(String tipo);

	public abstract Integer consultarEntidad(String tipo);

	public abstract void actualizarEntidad(String tipo);

	public abstract void eliminarEntidad(String tipo);

	public abstract DTOs crearDTO(String tipo);
}
