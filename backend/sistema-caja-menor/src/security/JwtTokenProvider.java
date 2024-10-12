package security;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

class JwtTokenProvider {

	private static byte[] secretByte = "340091za@".getBytes(StandardCharsets.UTF_8);
	private static SecretKey secretKey = Keys.hmacShaKeyFor(secretByte);

	public static String generateToken(String userId) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("cedula", userId);
		return Jwts.builder()
				.claims(claims)
				.subject(userId)
				.signWith(secretKey)
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
}
