package APIServlet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class ExceptionManagement {
	private static Map<Integer, Integer> errorCode = new HashMap<>();

	static {
		
		errorCode.put(404, Response.SC_NOT_FOUND);
		errorCode.put(405, Response.SC_METHOD_NOT_ALLOWED);
		errorCode.put(1008, Response.SC_NOT_FOUND);
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
		response.setStatus(errorCode.get(e.getErrorCode()));
		return response;
	}
}
