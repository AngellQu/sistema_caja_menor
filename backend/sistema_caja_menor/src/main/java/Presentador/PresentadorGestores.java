package Presentador;
import DTOs.DTOs;
import GestionMovientos.GestorRegistros;

public class PresentadorGestores {
	GestorRegistros<> gestor;
	
	public void insertarRegistro() {
		gestor.insertarEntidad(dto);
	}
}
