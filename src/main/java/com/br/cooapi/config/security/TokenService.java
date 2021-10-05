package com.br.cooapi.config.security;

import com.br.cooapi.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;


    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();

        Date today = new Date();

        Instant expirationTime = Instant.now()
                .plusSeconds(expiration);

        Date expirationDate = Date.from(expirationTime);

        Claims claims = Jwts.claims().setSubject(logged.getUsername());
        claims.put("roles", logged.getAuthorities());
        claims.put("userId", logged.getId());
        claims.put("username", logged.getUsername());

        return Jwts.builder()
                .setIssuer("RFB - ITAI")
                .setSubject(logged.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setClaims(claims)
                .compact();
    }

    public Boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.valueOf((Integer) body.get("userId"));
    }
}
