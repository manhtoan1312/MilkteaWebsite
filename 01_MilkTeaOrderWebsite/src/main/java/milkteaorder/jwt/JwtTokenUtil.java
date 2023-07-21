package milkteaorder.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import milkteaorder.config.security.CustomAccountDetail;

@Component
@CrossOrigin(origins ="http://localhost:3000")
public class JwtTokenUtil {
	private static final Logger  LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);	
	private static final long EXPIRE_DURATION = 1 * 60 * 60 * 1000; // 1h
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(CustomAccountDetail account) {
		return Jwts.builder()
				.setSubject(account.getId() + "," + account.getEmail() + ","+account.getRole() + "," + account.getName())
				.setIssuer("DuyHoang")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	
	public boolean validateAccessToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			LOGGER.error("Jwt Expired", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("Token is null, empty or has only whitespace", e);
		} catch (MalformedJwtException e) {
			LOGGER.error("Jwt Invalid", e);
		} catch (UnsupportedJwtException e) {
			LOGGER.error("Jwt is not supported", e);
		} catch (SignatureException e) {
			LOGGER.error("Signature validation failed", e);
		}
		return false;
	}
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	
	private Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean hasAuthorizationHeader(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		
		if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		} 
		
		return true;
	}
	
	public String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}
}
