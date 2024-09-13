package DTOs;

public class ContraseniaDTO implements DTOs{
	private Integer id;
	private String digito;
	
	public ContraseniaDTO(Integer id, String digito) {
		super();
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
}
