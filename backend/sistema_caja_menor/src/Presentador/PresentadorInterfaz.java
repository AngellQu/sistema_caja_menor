package Presentador;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;

public interface PresentadorInterfaz {

	ByteArrayOutputStream insertarEntidad(InputStream entidad) throws SQLException;

	ByteArrayOutputStream consultarEntidad(InputStream entidad) throws SQLException;

	ByteArrayOutputStream actualizarEntidad(InputStream entidad) throws SQLException;

	ByteArrayOutputStream eliminarEntidad(InputStream entidad) throws SQLException;

}
