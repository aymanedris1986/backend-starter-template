package com.ed.core.service.security;

import com.ed.core.dto.security.AppUser;
import com.ed.core.dto.security.TokenDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JWTService {


    public static final String TOKEN_TYPE = "bearer";
    @Value("${security.jwt.key}")
    private String secretKey;
    @Value("${security.jwt.expires-in}")
    private double expiresIn;
    public static final String USER_DUMMY_PASSWORD = "P@ssw0rd";
    //public static final int TIMEOUT_PERIOD = 1000 * 60 * 60 * 24 * 7 ;
    //public static final int TIMEOUT_PERIOD = 1000 * 60;//* 60 * 24 * 7 ;
    public static final String MAIN_ROLE_CLAIM = "mainRole";
    public static final String ROLES_CLAIM = "roles";
    public static final String FUNCTIONS_CLAIM = "functions";
    public static final String EMAIL_CLAIM = "email";
    public static final String USERID_CLAIM = "userId";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Map<String, Object> extraClaims, AppUser userDetails,long issuedAt, int timeoutPeriod) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(issuedAt)).setExpiration(new Date(issuedAt + timeoutPeriod)).signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
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
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private boolean validateTokenSignature(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
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


    public Map<String, Object> getExtraClaims(AppUser userInfoDTO) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put(MAIN_ROLE_CLAIM, userInfoDTO.getMainRole());
        extraClaims.put(ROLES_CLAIM, userInfoDTO.getRoles());
        extraClaims.put(FUNCTIONS_CLAIM, userInfoDTO.getPermissions());
        extraClaims.put(EMAIL_CLAIM, userInfoDTO.getEmail());
        extraClaims.put(USERID_CLAIM, userInfoDTO.getId());
        return extraClaims;
    }

    public AppUser tokenToUser(String token) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        AppUser userDetails = new AppUser(extractUsername(token), USER_DUMMY_PASSWORD, simpleGrantedAuthorities);
        String id = extractExtraClaim(token, JWTService.USERID_CLAIM, String.class);
        String email = extractExtraClaim(token, JWTService.EMAIL_CLAIM, String.class);
        String mainRole = extractExtraClaim(token, JWTService.MAIN_ROLE_CLAIM, String.class);
        List<String> rolesList = extractExtraClaim(token, JWTService.ROLES_CLAIM, List.class);
        List<String> permissionsList = extractExtraClaim(token, JWTService.FUNCTIONS_CLAIM, List.class);
        userDetails.setId(id);
        userDetails.setEmail(email);
        userDetails.setMainRole(mainRole);
        userDetails.setRoles(rolesList);
        userDetails.setPermissions(permissionsList);
        return userDetails;
    }


    public TokenDTO userToToken(AppUser userDetails) {
        Map<String, Object> extraClaims = getExtraClaims(userDetails);
        TokenDTO token = new TokenDTO();
        long time = System.currentTimeMillis();
        token.setAccess_token(generateToken(extraClaims, userDetails,time, getTimeoutPeriod() ));
        token.setRefresh_token(generateToken(extraClaims, userDetails,time, getTimeoutPeriod() * 2));
        token.setToken_type(TOKEN_TYPE);
        token.setExpires_in(Integer.toUnsignedLong(getTimeoutPeriod()/1000));
        token.setExp((time+ getTimeoutPeriod())/1000);
        token.setRefresh_token_exp( (time+(getTimeoutPeriod()*2)) /1000 );
        return token;
    }

    private int getTimeoutPeriod() {
        return (int) (1000 * 60 * (expiresIn/2));
    }


}

