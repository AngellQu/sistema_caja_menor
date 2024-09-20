package Presentador;

import DTOs.DTOs;
import FabricaDTOs.*;
import GestionMovientos.GestionMovimientos;
import GestionMovientos.GestorRegistros;

public class Presentador implements PresentadorInterfaz {
	private FabricaDTOs fabrica = new FabricaDTOsGenerics();
	private GestionMovimientos gestor = new GestorRegistros();
	
	@Override
	public Integer insertarEntidad(String tipo) {
		DTOs dto = crearDTO(tipo);
		return gestor.insertarEntidad(dto); 
	}

	@Override
	public Integer consultarEntidad(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEntidad(String tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEntidad(String tipo) {
		// TODO Auto-generated method stub
		
	}
	
	public DTOs crearDTO(String tipo) {
		DTOs dto = fabrica.getDTO(tipo);
		return dto;
	}
}
