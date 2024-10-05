package GestionMovientos;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;

import FabricaDAOs.FactoryDAOs;
import FabricaDAOs.FactoryGenericsDAO;
import Mapping.Mapper;
import Mapping.MappingServices;
import Persistencia.DAOs.GenericsDAO;

public class GestorRegistros implements GestionMovimientos {
	private FactoryDAOs fabricaDaos = new FactoryGenericsDAO();
	private MappingServices mapper = new Mapper();

	@Override
	public ByteArrayOutputStream insertarEntidad(String entidad) throws SQLException {
		return mapper.mapToJsonStream(getDAO(entidad).insertar());
	}

	@Override
	public ByteArrayOutputStream eliminarEntidad(String entidad) throws SQLException {
		return mapper.mapToJsonStream(getDAO(entidad).eliminar());
	}

	@Override
	public ByteArrayOutputStream consultarEntidad(String entidad) throws SQLException {
		return mapper.mapToJsonStream(getDAO(entidad).consultar());
	}

	@Override
	public ByteArrayOutputStream actualizarEntidad(String entidad) throws SQLException {
		return mapper.mapToJsonStream(getDAO(entidad).actualizar());
	}
	
	private GenericsDAO getDAO(String entidad) {
		return fabricaDaos.getDAO(entidad);
	}

}
