package Persistencia.DAOs;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HuespedDAO implements GenericsDAO {
	private Integer cedula;
	private String nombre;
	private String telefono;

	@JsonCreator
	public HuespedDAO(@JsonProperty("cedula") Integer cedula, @JsonProperty("nombre") String nombre,
			@JsonProperty("telefono") String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
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
