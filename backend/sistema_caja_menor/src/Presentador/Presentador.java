package Presentador;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import GestionMovientos.GestionMovimientos;
import GestionMovientos.GestorRegistros;

public class Presentador implements PresentadorInterfaz {
	private GestionMovimientos gestor = new GestorRegistros();

	@Override
	public ByteArrayOutputStream insertarEntidad(InputStream entidad) throws SQLException {
		return gestor.insertarEntidad(getRequestToString(entidad));
	}

	@Override
	public ByteArrayOutputStream eliminarEntidad(InputStream entidad) throws SQLException {
		return gestor.eliminarEntidad(getRequestToString(entidad));
	}

	@Override
	public ByteArrayOutputStream consultarEntidad(InputStream entidad) throws SQLException {
		return gestor.consultarEntidad(getRequestToString(entidad));
	}

	@Override
	public ByteArrayOutputStream actualizarEntidad(InputStream entidad) throws SQLException {
		return gestor.actualizarEntidad(getRequestToString(entidad));
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
