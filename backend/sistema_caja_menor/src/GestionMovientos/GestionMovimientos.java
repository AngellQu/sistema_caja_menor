package GestionMovientos;

import java.io.ByteArrayOutputStream;

public interface GestionMovimientos {

	ByteArrayOutputStream insertarEntidad(String entidad);

	ByteArrayOutputStream consultarEntidad(String entidad);

	ByteArrayOutputStream  actualizarEntidad(String entidad);

	ByteArrayOutputStream  eliminarEntidad(String entidad);

}
