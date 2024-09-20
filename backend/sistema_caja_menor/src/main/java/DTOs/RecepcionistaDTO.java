package DTOs;

public class RecepcionistaDTO implements DTOs {
	private String nombre;
	private String correo;
	private String direccion;
	private String telefono;
	private Integer cedula;
	private RecepcionistaDTO recepcionista;

	public RecepcionistaDTO() {
	}

	public RecepcionistaDTO(String nombre, String correo, String direccion, String telefono, Integer cedula) {
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public RecepcionistaDTO getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(RecepcionistaDTO recepcionista) {
		this.recepcionista = recepcionista;
	}
}
