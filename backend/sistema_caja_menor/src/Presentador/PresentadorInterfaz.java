package Presentador;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public interface PresentadorInterfaz {

	ByteArrayOutputStream insertarEntidad(InputStream entidad);

	ByteArrayOutputStream consultarEntidad(InputStream entidad);

	ByteArrayOutputStream actualizarEntidad(InputStream entidad);

	ByteArrayOutputStream eliminarEntidad(InputStream entidad);

}
