package api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public abstract class ExceptionManagement {
	private static Map<Integer, Integer> errorCode = new HashMap<>();
	private static Map<String, Integer> errorMessage = new HashMap<>();

	static {
		errorMessage.put("ClassNotFoundException", Response.SC_NOT_FOUND);
		errorMessage.put("NullPointerException", Response.SC_INTERNAL_SERVER_ERROR);
		errorMessage.put("IllegalArgumentException", Response.SC_INTERNAL_SERVER_ERROR);
		errorMessage.put("InvalidFormatException", Response.SC_BAD_REQUEST);
		errorMessage.put("MismatchedInputException", Response.SC_BAD_REQUEST);
		errorCode.put(401, Response.SC_UNAUTHORIZED);
		errorCode.put(404, Response.SC_NOT_FOUND);
		errorCode.put(405, Response.SC_METHOD_NOT_ALLOWED);
		errorCode.put(1008, Response.SC_NOT_FOUND);
		errorCode.put(1048, Response.SC_BAD_REQUEST);
		errorCode.put(1062, Response.SC_CONFLICT);
		errorCode.put(1064, Response.SC_BAD_REQUEST);
		errorCode.put(1216, Response.SC_BAD_REQUEST);
		errorCode.put(1217, Response.SC_BAD_REQUEST);
		errorCode.put(1264, Response.SC_BAD_REQUEST);
		errorCode.put(1265, Response.SC_BAD_REQUEST);
		errorCode.put(1451, Response.SC_CONFLICT);
		errorCode.put(1452, Response.SC_BAD_REQUEST);
		errorCode.put(1525, Response.SC_BAD_REQUEST);
		errorCode.put(2000, Response.SC_INTERNAL_SERVER_ERROR);
		errorCode.put(2003, Response.SC_SERVICE_UNAVAILABLE);
		errorCode.put(3819, Response.SC_BAD_REQUEST);
	}

	static HttpServletResponse getErrorStatus(HttpServletResponse response, SQLException e) {
		if (errorCode.containsKey(e.getErrorCode())) {
			response.setStatus(errorCode.get(e.getErrorCode()));
		} else {
			System.out.println(e.getErrorCode());
		}
		return response;
	}

	static HttpServletResponse getErrorStatus(HttpServletResponse response, Exception e) {
		if (errorMessage.containsKey(e.getClass().getSimpleName())) {
			response.setStatus(errorMessage.get(e.getClass().getSimpleName()));
		} else {
			System.out.println(e.getClass().getSimpleName());
		}
		return response;
	}
}
