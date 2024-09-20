package FabricaDTOs;

import java.util.HashMap;
import java.util.Map;

import DTOs.*;

public class FabricaDTOsGenerics implements FabricaDTOs {
	private Map<String, DTOs> productosDTO = new HashMap<>();

	public FabricaDTOsGenerics() {
		productosDTO.put("IngresoProducto", new IngresoProductoDTO());
		productosDTO.put("IngresoHospedaje", new IngresoHospedajeDTO());
		productosDTO.put("Retiro", new RetiroDTO());
		productosDTO.put("Huesped", new HuespedDTO());
		productosDTO.put("Retirante", new RetiranteDTO());
		productosDTO.put("Recepcionista", new RecepcionistaDTO());
		productosDTO.put("Contrasenia", new ContraseniaDTO());
		productosDTO.put("Base", new BaseDTO());
		productosDTO.put("Hospedaje", new HospedajeDTO());
		productosDTO.put("Producto", new ProductoDTO());
	}

	@Override
	public DTOs getDTO(String tipo) {
		DTOs dto = productosDTO.get(tipo);
		return dto;
	}

}
