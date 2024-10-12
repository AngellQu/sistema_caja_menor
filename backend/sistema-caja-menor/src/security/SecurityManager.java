package security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class SecurityManager {
	private static final Argon2 argon = Argon2Factory.create();
	private static String token;

	public List<Map<String, Object>> VerifyUserAuthorization(String result, String userId, String password) throws SQLException {
		if (checkUserExistence(result, password)) {
			List<Map<String, Object>> rs = new ArrayList<>();
			Map<String, Object> token = new HashMap<>();
			token.put("token",  createToken(userId));
			rs.add(token);
			return rs;
		} else {
			throw new SQLException("usuario o contrase�a incorrectos", "UNAUTHORIZED", 401);
		}
	}

	public String createPasswordHash(String password) { 
		return argon.hash(1, 40000, 1, password.toCharArray());
	}
	
	public String getIdUserFromToken() {
		return JwtTokenProvider.getUserIdFromToken(token);
	}
		
	public static void setToken(String token) {
		SecurityManager.token = token;
	}

	private static Boolean checkUserExistence(String result, String password) throws SQLException {
		if (!result.equals("false")) {
			return checkPasswordMatch(result, password);
		} else {
			throw new SQLException("usuario no existe", "NOT_FOUND", 404);
		}
	}
	
	private static  Boolean checkPasswordMatch(String hash, String password) {
		return argon.verify(hash, password.getBytes());
	}

	private static String createToken(String userId) {
		return JwtTokenProvider.generateToken(userId);
	}
}
