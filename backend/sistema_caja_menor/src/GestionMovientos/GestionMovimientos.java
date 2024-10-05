package GestionMovientos;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;

public interface GestionMovimientos {

	ByteArrayOutputStream insertarEntidad(String entidad) throws SQLException;

	ByteArrayOutputStream consultarEntidad(String entidad) throws SQLException;

	ByteArrayOutputStream  actualizarEntidad(String entidad)throws SQLException;

	ByteArrayOutputStream  eliminarEntidad(String entidad)throws SQLException;

}
