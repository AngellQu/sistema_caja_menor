package DTOs;

public class HospedajeDTO implements DTOs {
	private Integer idHuesped;
	private int habitacion;
	private String fechaIngreso;
	private String fechaSalida;
	private HospedajeDTO hospedaje;

	public HospedajeDTO() {

	}

	public HospedajeDTO(Integer idHuesped, int habitacion, String fechaIngreso, String fechaSalida) {
		this.idHuesped = idHuesped;
		this.habitacion = habitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Integer getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Integer idHuesped) {
		this.idHuesped = idHuesped;
	}

	public int getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(int habitacion) {
		this.habitacion = habitacion;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public HospedajeDTO getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(HospedajeDTO hospedaje) {
		this.hospedaje = hospedaje;
	}
}
