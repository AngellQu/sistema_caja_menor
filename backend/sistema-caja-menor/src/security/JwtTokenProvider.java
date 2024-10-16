package security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class JwtTokenProvider {

	private static byte[] secretByte;
	private static SecretKey secretKey;

	public static String generateToken(String userId) {
		generateSecretByte();
		secretKey = Keys.hmacShaKeyFor(secretByte);
		Map<String, Object> claims = new HashMap<>();
		claims.put("cedula", userId);
		return Jwts.builder()
				.claims(claims)
				.subject(userId)
				.encryptWith(secretKey, Jwts.ENC.A256CBC_HS512)
				.compact();
	}

	public static String getUserIdFromToken(String token) {
		return Jwts.parser()
				.decryptWith(secretKey)
				.build()
				.parseEncryptedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public static Boolean deleteSecretByte() {
		secretByte = null;
		return (secretByte == null)? true: false;
	}
	
	private static void generateSecretByte() {
		Random random = new Random();
		int length = 64;
		String dictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$-*?";
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < length; i++) { 
			key.append(dictionary.charAt(random.nextInt(dictionary.length())));
		}
		secretByte = key.toString().getBytes(StandardCharsets.UTF_8);
	}
}
