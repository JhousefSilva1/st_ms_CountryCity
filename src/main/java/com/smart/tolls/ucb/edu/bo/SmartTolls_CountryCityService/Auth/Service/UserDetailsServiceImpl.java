package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // No verificamos contra una base de datos local
//        // Solo creamos un UserDetails básico basado en el token JWT válido
//        return User.withUsername(username)
//                .password("") // No necesitamos el password para validación JWT
//                .authorities("ROLE_ADMINISTRADOR") // O los roles que extraigas del token
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
//}

    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // En este caso, el "username" es realmente el subject del token
        // Los roles deben venir en el token JWT
        return User.withUsername(username)
                .password("") // No necesitamos password para JWT
                .authorities("ROLE_USER") // Rol por defecto
                .build();
    }

    public UserDetails loadUserFromJwt(String token) {
        String username = jwtService.extractUsername(token);
        List<String> roles = jwtService.extractRoles(token); // Implementa este método en JwtService

        return User.withUsername(username)
                .password("")
                .authorities(roles.toArray(new String[0]))
                .build();
    }
}