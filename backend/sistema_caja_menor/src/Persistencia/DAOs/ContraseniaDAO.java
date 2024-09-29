package Persistencia.DAOs;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContraseniaDAO implements GenericsDAO {
	private Integer id;
	private String digito;

	@JsonCreator
	public ContraseniaDAO(@JsonProperty("id") Integer id, @JsonProperty("digito") String digito) {
		this.id = id;
		this.digito = digito;
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
