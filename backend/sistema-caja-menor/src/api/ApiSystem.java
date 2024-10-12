package api;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import presenter.Presenter;

@WebServlet("/api-system/*")
public class ApiSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		String resource = request.getPathInfo();
		if (token == null && !(resource.contains("recepcionistas"))) {
			response.setStatus(Response.SC_UNAUTHORIZED);
			response.flushBuffer();
		} else {
			InputStream body = request.getInputStream();
			try {
				String result = Presenter.insert(IOJsonDataBuilder.getRequestToString(body, resource), token);
				response.setStatus(Response.SC_CREATED);
				response.getOutputStream().write(IOJsonDataBuilder.getResponseToStream(result));
				response.flushBuffer();
			} catch (SQLException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (ClassNotFoundException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (Exception e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token == null) {
			response.setStatus(Response.SC_UNAUTHORIZED);
			response.flushBuffer();
		} else {
			try {
				String result = Presenter
						.delete(IOJsonDataBuilder.urlToMapString(request.getParameterMap(), request.getPathInfo()), token);
				response.setStatus(Response.SC_OK);
				response.getOutputStream().write(IOJsonDataBuilder.getResponseToStream(result));
				response.flushBuffer();
			} catch (SQLException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (ClassNotFoundException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (Exception e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token == null) {
			response.setStatus(Response.SC_UNAUTHORIZED);
			response.flushBuffer();
		} else {
			try {
				String result = Presenter
						.query(IOJsonDataBuilder.urlToMapString(request.getParameterMap(), request.getPathInfo()), token);
				response.setStatus(Response.SC_OK);
				response.getOutputStream().write(IOJsonDataBuilder.getResponseToStream(result));
				response.flushBuffer();
			} catch (SQLException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (ClassNotFoundException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (Exception e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			}
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token == null) {
			response.setStatus(Response.SC_UNAUTHORIZED);
			response.flushBuffer();
		} else {
			InputStream body = request.getInputStream();
			try {
				String result = Presenter.update(IOJsonDataBuilder.getRequestToString(body, request.getPathInfo()), token);
				response.setStatus(Response.SC_OK);
				response.getOutputStream().write(IOJsonDataBuilder.getResponseToStream(result));
				response.flushBuffer();
			} catch (SQLException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (ClassNotFoundException e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			} catch (Exception e) {
				ExceptionManagement.getErrorStatus(response, e);
				response.getOutputStream().write(e.getMessage().getBytes());
				response.flushBuffer();
			}
		}
	}
}
