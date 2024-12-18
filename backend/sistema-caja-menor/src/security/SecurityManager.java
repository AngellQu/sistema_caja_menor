package security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.mkammerer.argon2.Argon2Factory;

public class SecurityManager {
	private static String token;

	public List<Map<String, Object>> VerifyUserAuthorization(String result, String userId, String password)
			throws SQLException {
		if (checkUserExistence(result, password)) {
			List<Map<String, Object>> rs = new ArrayList<>();
			Map<String, Object> token = new HashMap<>();
			token.put("token", createToken(userId));
			rs.add(token);
			return rs;
		} else {
			throw new SQLException("usuario o contraseņa incorrectos", "UNAUTHORIZED", 401);
		}
	}

	public String createPasswordHash(String password) {
		return Argon2Factory.create().hash(10, 40000, 1, password.toCharArray());
	}

	public Integer logOut() {
		return JwtTokenProvider.deleteSecretByte()? 1 : 0;
	}

	public String getIdUserFromToken() {
		return JwtTokenProvider.getUserIdFromToken(token);
	}

	public static Boolean isthereASessionActivated(String token) {
		return JwtTokenProvider.getUserIdFromToken(token) != null;
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

	private static Boolean checkPasswordMatch(String hash, String password) {
		return Argon2Factory.create().verify(hash, password.getBytes());
	}

	private static String createToken(String userId) {
		return JwtTokenProvider.generateToken(userId);
	}
}
