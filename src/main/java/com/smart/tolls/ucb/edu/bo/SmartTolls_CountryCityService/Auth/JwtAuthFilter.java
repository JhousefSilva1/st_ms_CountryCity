package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    // Esta clave debe ser la misma que usaste en MsPersons para firmar el token
    private final String SECRET_KEY = "una1clave2segura3y4mas5larga6para7jwt8256bits";

    private Claims extractClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(io.jsonwebtoken.security.Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token expirado");
        } catch (MalformedJwtException e) {
            throw new RuntimeException("Token mal formado");
        } catch (Exception e) {
            throw new RuntimeException("Token inválido");
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no presente o incorrecto");
            return;
        }

        String token = authHeader.substring(7);

        try {
            Claims claims = extractClaims(token);
            String username = claims.getSubject();

            UserDetails userDetails = new User(username, "", List.of(new SimpleGrantedAuthority("ROLE_USER")));
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }

        filterChain.doFilter(request, response);
    }
}