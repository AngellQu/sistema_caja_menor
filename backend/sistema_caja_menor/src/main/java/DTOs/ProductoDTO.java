package DTOs;

public class ProductoDTO implements DTOs {
	private Integer id;
	private String nombre;
	private Integer precio;
	private ProductoDTO producto;

	public ProductoDTO() {
	}

	public ProductoDTO(Integer id, String nombre, Integer precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
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

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
}
