package FabricaDAOs;

import java.util.HashMap;
import java.util.Map;

import DTOs.DTOs;
import Persistencia.DAOs.*;

public class FabricaDAOsGenerics implements FabricaDAOs {
	private Map<String, DAOs<DTOs>> productosDAO = new HashMap<>();

	public FabricaDAOsGenerics() {
		productosDAO.put("IngresoHospedajeDTO", new IngresoHospedajeDAO());
		productosDAO.put("IngresoProductoDTO", new IngresoProductoDAO());
		productosDAO.put("RetiroDTO", new RetiroDAO());
		productosDAO.put("RecepcionistaDTO", new RecepcionistaDAO());
		productosDAO.put("ContraseniaDTO", new ContraseniaDAO());
	}

	@Override
	public GenericsDAO<DTOs> getDao(String tipo) {
		return (GenericsDAO<DTOs>) productosDAO.get(tipo);
	}
}