package FabricaDAOs;

import java.util.HashMap;
import java.util.Map;

import Mapping.Mapper;
import Mapping.MappingServices;
import Persistencia.DAOs.*;

public class FactoryGenericsDAO implements FactoryDAOs {
	private Map<String, Class<? extends GenericsDAO>> productosDAO = new HashMap<>();
	private MappingServices mapper = new Mapper();

	public FactoryGenericsDAO() {
		registrarDAO("IngresoHospedaje", IngresoHospedajeDAO.class);
		registrarDAO("IngresoProducto", IngresoProductoDAO.class);
		registrarDAO("Retiro", RetiroDAO.class);
		registrarDAO("Recepcionista", RecepcionistaDAO.class);
		registrarDAO("Contrasenia ", ContraseniaDAO.class);
	}

	@Override
	public GenericsDAO getDAO(String entidad) {
		 return mapper.mapToDao(entidad, productosDAO.get(mapper.getTypeEntityString(entidad)));
	}

	@Override
	public void registrarDAO(String clave, Class<? extends GenericsDAO> daoClass) {
		productosDAO.put(clave, daoClass);
	}
}