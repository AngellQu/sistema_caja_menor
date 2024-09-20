package DTOs;

public class BaseDTO implements DTOs {
	private String fecha;
	private String saldo;
	private BaseDTO base;

	public BaseDTO() {

	}

	public BaseDTO(String fecha, String saldo) {
		this.fecha = fecha;
		this.saldo = saldo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public BaseDTO getBase() {
		return base;
	}

	public void setBase(BaseDTO base) {
		this.base = base;
	}

}
