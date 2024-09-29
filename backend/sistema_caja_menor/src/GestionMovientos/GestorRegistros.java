package GestionMovientos;

import java.io.ByteArrayOutputStream;

import FabricaDAOs.FactoryDAOs;
import FabricaDAOs.FactoryGenericsDAO;
import Mapping.Mapper;
import Mapping.MappingServices;
import Persistencia.DAOs.GenericsDAO;

public class GestorRegistros implements GestionMovimientos {
	private FactoryDAOs fabricaDaos = new FactoryGenericsDAO();
	private MappingServices mapper = new Mapper();

	@Override
	public ByteArrayOutputStream insertarEntidad(String entidad) {
		GenericsDAO dao = fabricaDaos.getDAO(entidad);
		return mapper.mapToJsonStream(dao.insertar());
	}

	@Override
	public ByteArrayOutputStream consultarEntidad(String entidad) {
		return null;
	}

	@Override
	public ByteArrayOutputStream actualizarEntidad(String entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream eliminarEntidad(String entidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
