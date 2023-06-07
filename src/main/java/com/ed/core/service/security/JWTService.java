package com.ed.core.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JWTService {
    private static final String SECRET_KEY = "77397A24432646294A404E635266556A586E3272357538782F4125442A472D4B";
    public static final int TIMEOUT_PERIOD = 1000 * 60 * 60 * 24 * 7 ;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + TIMEOUT_PERIOD)).signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && validateTokenSignature(token) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private boolean validateTokenSignature(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.err.println("inside validateTokenSignature error");
            return false;
        }
    }

    public boolean isTokenValid(String token) {
        return validateTokenSignature(token) && !isTokenExpired(token);
    }

    public String generateToken(Map<String, Object> extraClaims) {
        return Jwts.builder().setClaims(extraClaims).setSubject((String) extraClaims.get("sub")).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    public String refreshToken(Map<String, Object> extraClaims) {
        return Jwts.builder().setClaims(extraClaims).setSubject((String) extraClaims.get("sub")).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 2000 * 60 * 24)).signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    public <T> T extractExtraClaim(String token, String key, Class<T> clazz) {
        T o = null;
        boolean isTokenValid = isTokenValid(token);
        if (isTokenValid) {
            o = extractClaim(token, claims -> claims.get(key, clazz));
        }
        return o;
    }

    public String updateClaim(String token, String claimKey, Object claimValue) {
        if (isTokenValid(token)) {
            Claims claims = extractAllClaims(token);
            claims.put(claimKey, claimValue);
            String newToken = refreshToken(claims);
            return newToken;
        }
        return null;
    }

    public String updateClaim(String token, Map<String, Object> extraClaims) {
        if (isTokenValid(token)) {
            Claims claims = extractAllClaims(token);
            extraClaims.forEach((claimKey, claimValue) -> claims.put(claimKey, claimValue));
            String newToken = refreshToken(claims);
            return newToken;
        }
        return null;
    }

    public String refreshToken(String token) {
        String newToken = null;
        if (isTokenValid(token)) {
            Claims claims = extractAllClaims(token);
            newToken = refreshToken(claims);
        }
        return newToken;
    }

    public Map<String,Object> authoritiesToClaims(UserDetails userDetails){
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("roles", userDetails.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList()));
        return extraClaims;
    }
}

