package Persistencia.DAOs;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoDAO implements GenericsDAO {
	private Integer id;
	private String nombre;
	private Integer precio;

	@JsonCreator
	public ProductoDAO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre,
			@JsonProperty("precio") Integer precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public List<Map<String, Object>> insertar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> eliminar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> actualizar() {
		// TODO Auto-generated method stub
		return null;
	}
}
