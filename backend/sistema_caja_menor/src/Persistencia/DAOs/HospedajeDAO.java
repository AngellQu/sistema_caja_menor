package Persistencia.DAOs;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HospedajeDAO implements GenericsDAO {
	private Integer idHuesped;
	private Integer habitacion;
	private String fechaIngreso;
	private String fechaSalida;

	@JsonCreator
	public HospedajeDAO(@JsonProperty("idHuesped") Integer idHuesped, @JsonProperty("habitacion") Integer habitacion,
			@JsonProperty("fechaIngreso") String fechaIngreso, @JsonProperty("fechaSalida") String fechaSalida) {
		this.idHuesped = idHuesped;
		this.habitacion = habitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
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
