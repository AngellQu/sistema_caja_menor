package Persistencia.DAOs;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RetiranteDAO implements GenericsDAO {
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;

	@JsonCreator
	public RetiranteDAO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre,
			@JsonProperty("direccion") String direccion, @JsonProperty("telefono")String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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
