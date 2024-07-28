package com.nocountry.virtualclinic.infra.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class TokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generarToken(String username) {
        try {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
        } catch (JwtException exception) {
            throw new TokenCreationException("Error creando el token JWT", exception);
        }
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

//    public String getSubject(String token) {
//        if (token == null) {
//            throw new TokenVerificationException("Token nulo", new Exception());
//        }
//        try {
//            SignatureAlgorithm algorithm = SignatureAlgorithm.HS256(secretKey);
//            DecodedJWT verifier = JWT.require(algorithm)
//                    .withIssuer(ISSUER)
//                    .build()
//                    .verify(token);
//            return verifier.getSubject();
//        } catch (JWTVerificationException exception) {
//            throw new TokenVerificationException("Error verificando el token JWT", exception);
//        }
//    }
//
//    private Instant generarFechaExpiracion() {
//        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.UTC); // Uso UTC para mayor consistencia
//    }

    // Excepciones personalizadas
    public static class TokenCreationException extends RuntimeException {
        public TokenCreationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class TokenVerificationException extends RuntimeException {
        public TokenVerificationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
