package FabricaDAOs;

import DTOs.DTOs;
import Persistencia.DAOs.GenericsDAO;

public interface FabricaDAOs {

	public abstract GenericsDAO<DTOs> getDao(String tipo);

}
