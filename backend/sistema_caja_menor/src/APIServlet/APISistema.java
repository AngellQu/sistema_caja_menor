package APIServlet;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import Presentador.Presentador;
import Presentador.PresentadorInterfaz;

@WebServlet("/APISistema")
public class APISistema extends HttpServlet {
	private PresentadorInterfaz presentador = new Presentador();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream body = request.getInputStream();
		try {
			ByteArrayOutputStream resp = presentador.insertarEntidad(body);
			response.setStatus(Response.SC_CREATED);
			response.getOutputStream().write(resp.toByteArray());
			response.flushBuffer();
		} catch (SQLException e) {
			ExceptionManagement.getErrorStatus(response, e);
			response.getOutputStream().write(e.getMessage().getBytes());
			response.flushBuffer();
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream body = request.getInputStream();
		try {
			ByteArrayOutputStream resp = presentador.eliminarEntidad(body);
			response.setStatus(Response.SC_OK);
			response.getOutputStream().write(resp.toByteArray());
			response.flushBuffer();
		} catch (SQLException e) {
			ExceptionManagement.getErrorStatus(response, e);
			response.getOutputStream().write(e.getMessage().getBytes());
			response.flushBuffer();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream body = request.getInputStream();
		try {
			ByteArrayOutputStream resp = presentador.consultarEntidad(body);
			response.setStatus(Response.SC_OK);
			response.getOutputStream().write(resp.toByteArray());
			response.flushBuffer();
		} catch (SQLException e) {
			ExceptionManagement.getErrorStatus(response, e);
			response.getOutputStream().write(e.getMessage().getBytes());
			response.flushBuffer();
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream body = request.getInputStream();
		try {
			ByteArrayOutputStream resp = presentador.actualizarEntidad(body);
			response.setStatus(Response.SC_OK);
			response.getOutputStream().write(resp.toByteArray());
			response.flushBuffer();
		} catch (SQLException e) {
			ExceptionManagement.getErrorStatus(response, e);
			response.getOutputStream().write(e.getMessage().getBytes());
			response.flushBuffer();
		}
	}

}
