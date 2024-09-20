package DTOs;

public class RetiranteDTO implements DTOs {
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private RetiranteDTO retirante;

	public RetiranteDTO() {
	}

	public RetiranteDTO(Integer id, String nombre, String direccion, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public RetiranteDTO getRetirante() {
		return retirante;
	}

	public void setRetirante(RetiranteDTO retirante) {
		this.retirante = retirante;
	}
}
