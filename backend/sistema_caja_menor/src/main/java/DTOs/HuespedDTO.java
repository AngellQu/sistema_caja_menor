package DTOs;

public class HuespedDTO implements DTOs {
	private Integer cedula;
	private String nombre;
	private String telefono;
	private HuespedDTO huesped;

	public HuespedDTO() {

	}

	public HuespedDTO(Integer cedula, String nombre, String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public HuespedDTO getHuesped() {
		return huesped;
	}

	public void setHuesped(HuespedDTO huesped) {
		this.huesped = huesped;
	}
}
