package FabricaDAOs;

import DTOs.DTOs;
import Persistencia.DAOs.GenericsDAO;

public interface FabricaDAOs {
	GenericsDAO<DTOs> getDAO(String tipo);
}