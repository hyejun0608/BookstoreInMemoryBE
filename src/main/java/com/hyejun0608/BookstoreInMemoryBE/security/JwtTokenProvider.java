package com.hyejun0608.BookstoreInMemoryBE.security;

import com.hyejun0608.BookstoreInMemoryBE.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private String secretKey;

    private Long accessTokenExpiration;

    private static final String HEADER = "Authorization";

    private static final String PREFIX = "Bearer";

    private AuthDetailsService authDetailsService;

    public String getAccessToken(String id) {
        return generateAccessToken(id);
    }

    public String generateAccessToken(String id) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setSubject(id)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HEADER);

        if(bearer != null && bearer.startsWith(PREFIX)) {
            return bearer.substring(7);
        }

        return null;
    }

    public boolean validateToken(String token) {
        try {
            return getTokenBody(token).getExpiration().after(new Date());
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private String getId(String token) {
        try {
            return getTokenBody(token).getSubject();
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private JwsHeader getHeader(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getHeader();
    }

    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

    private String encoding() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(encoding())
                .parseClaimsJws(token).getBody();
    }

}
