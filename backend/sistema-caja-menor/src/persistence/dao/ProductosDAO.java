package persistence.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import persistence.MySqlConnection;

public class ProductosDAO implements AbstractDataAcces {
	private Connection conn = MySqlConnection.getConn();
	private Integer id;
	private String nombre;
	private Integer precio;

	static {
		RegistryDataAcces.register("Productos", ProductosDAO.class);
	}

	@JsonCreator
	public ProductosDAO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre,
			@JsonProperty("precio") Integer precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public List<Map<String, Object>> insert() throws SQLException {
		String sql = "insert into producto values(?,?,?)";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, id);
			stm.setString(2, nombre);
			stm.setInt(3, precio);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> delete() throws SQLException {
		String sql = "delete from producto where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, id);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> query() throws SQLException {
		String sql = "select * from producto where id = ? or nombre = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setObject(1, id);
			stm.setObject(2, nombre);
			return AbstractDataAcces.result(stm.executeQuery());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> update() throws SQLException {
		String sql = "call actualizar_producto(?,?,?)";
		try (CallableStatement stm = conn.prepareCall(sql);) {
			stm.setObject(1, id);
			stm.setObject(2, nombre);
			stm.setObject(3, precio);
			return AbstractDataAcces.result(stm.executeUpdate());
		} catch (SQLException e) {
			throw e;
		} 
	}
}
