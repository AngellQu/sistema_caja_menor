package Presentador;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import GestionMovientos.GestionMovimientos;
import GestionMovientos.GestorRegistros;

public class Presentador implements PresentadorInterfaz {
	private GestionMovimientos gestor = new GestorRegistros();

	@Override
	public ByteArrayOutputStream insertarEntidad(InputStream entidad) {
		return gestor.insertarEntidad(getRequestToString(entidad));
	}

	@Override
	public ByteArrayOutputStream consultarEntidad(InputStream entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream actualizarEntidad(InputStream entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream eliminarEntidad(InputStream entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getRequestToString(InputStream entidad) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(entidad));
		StringBuilder stringEntidad = new StringBuilder();
		String line;
		try {
			while ((line = bf.readLine()) != null) {
				stringEntidad.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringEntidad.toString();
	}

}
