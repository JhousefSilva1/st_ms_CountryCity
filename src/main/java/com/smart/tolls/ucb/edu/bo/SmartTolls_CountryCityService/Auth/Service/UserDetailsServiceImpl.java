package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        // En un escenario real, obtendrías los roles del token
        // Esto es un ejemplo simplificado
        String[] roles = {"ADMINISTRADOR"}; // Extraer estos del token

        return User.withUsername(username)
                .password("")
                .roles(roles)
                .build();
    }
}