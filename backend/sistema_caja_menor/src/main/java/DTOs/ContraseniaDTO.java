package DTOs;

public class ContraseniaDTO implements DTOs {
	private Integer id;
	private String digito;
	private ContraseniaDTO contrasenia;

	public ContraseniaDTO() {
	}

	public ContraseniaDTO(Integer id, String digito) {
		this.id = id;
		this.digito = digito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public ContraseniaDTO getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(ContraseniaDTO contrasenia) {
		this.contrasenia = contrasenia;
	}
}
