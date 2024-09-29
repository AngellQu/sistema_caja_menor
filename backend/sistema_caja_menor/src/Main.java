
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import Presentador.Presentador;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStream inputStream = new FileInputStream("C:/Users/migue/Desktop/ingresoProducto.json");
		Presentador presentador = new Presentador();
		System.out.println(presentador.insertarEntidad(inputStream));

	}
}
