package DTOs;

public class IngresoHospedajeDTO implements DTOs {
	private String metodoPago;
	private Integer monto;
	private Integer IdRecepcionista;

	public IngresoHospedajeDTO() {
		super();
	}

	public IngresoHospedajeDTO(String metodoPago, Integer monto, Integer idRecepcionista) {
		this.metodoPago = metodoPago;
		this.monto = monto;
		IdRecepcionista = idRecepcionista;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getIdRecepcionista() {
		return IdRecepcionista;
	}

	public void setIdRecepcionista(Integer idRecepcionista) {
		this.IdRecepcionista = idRecepcionista;
	}

	public IngresoHospedajeDTO getInstancia() {
		return this;
	}
}
