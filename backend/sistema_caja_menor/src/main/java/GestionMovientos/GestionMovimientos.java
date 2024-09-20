package GestionMovientos;

import DTOs.DTOs;

public interface GestionMovimientos {

	public abstract Integer insertarEntidad(DTOs dto);

	public abstract Integer consultarEntidad(DTOs dto);

	public abstract void actualizarEntidad(DTOs dto);

	public abstract void eliminarEntidad(DTOs dto);
}
