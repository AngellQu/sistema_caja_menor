package FabricaDAOs;

import Persistencia.DAOs.GenericsDAO;

public interface FactoryDAOs {

	GenericsDAO getDAO(String entidad);

	void registrarDAO(String clave, Class<? extends GenericsDAO> dao);
}