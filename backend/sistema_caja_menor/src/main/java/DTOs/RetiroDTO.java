package DTOs;

public class RetiroDTO implements DTOs {
	private Integer idRetirante;
	private Integer idRecepcionista;
	private String descripcion;
	private Integer monto;
	private RetiroDTO retiro;

	public RetiroDTO() {
	}

	public RetiroDTO(Integer idRetirante, Integer idRecepcionista, String descripcion, Integer monto) {
		this.idRetirante = idRetirante;
		this.idRecepcionista = idRecepcionista;
		this.descripcion = descripcion;
		this.monto = monto;
	}

	public Integer getIdRetirante() {
		return idRetirante;
	}

	public void setIdRetirante(Integer idRetirante) {
		this.idRetirante = idRetirante;
	}

	public Integer getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(Integer idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public RetiroDTO getRetiro() {
		return retiro;
	}

	public void setRetiro(RetiroDTO retiro) {
		this.retiro = retiro;
	}
}
