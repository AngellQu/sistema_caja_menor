import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTOs.DTOs;
import DTOs.IngresoProductoDTO;
import GestionMovientos.GestionMovimientos;
import GestionMovientos.GestorRegistros;
import InversionControl.InversorIngresoProducto;
import Presentador.*;

public class Main {

	public static void main(String[] args) {

		IngresoProductoDTO producto = new IngresoProductoDTO("detodito", 89, "efectivo", 1225091161, 1111);
		GestionMovimientos gestor = new GestorRegistros();
		PresentadorInterfaz presentador = new Presentador();
		InversorIngresoProducto in = new InversorIngresoProducto(gestor, presentador);
		in.setDto(producto);
	    System.out.println(in.insertar());
		
		

}
