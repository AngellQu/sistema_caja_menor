package DTOs;

public class IngresoProductoDTO implements DTOs {
	private String nombre;
	private Integer cantidad;
	private String metodoPago;
	private Integer IdRecepcionista;
	private Integer IdHuesped;
	private IngresoProductoDTO ingresoProducto;

	public IngresoProductoDTO() {
	}

	public IngresoProductoDTO(String nombre, Integer cantidad, String metodoPago, Integer idRecepcionista,
			Integer idHuesped) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.metodoPago = metodoPago;
		this.IdRecepcionista = idRecepcionista;
		this.IdHuesped = idHuesped;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Integer getIdRecepcionista() {
		return IdRecepcionista;
	}

	public void setIdRecepcionista(Integer idRecepcionista) {
		this.IdRecepcionista = idRecepcionista;
	}

	public Integer getIdHuesped() {
		return IdHuesped;
	}

	public void setIdHuesped(Integer idHuesped) {
		this.IdHuesped = idHuesped;
	}

	public IngresoProductoDTO getIngresoProducto() {
		return ingresoProducto;
	}

	public void setIngresoProducto(IngresoProductoDTO ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
	}
}
