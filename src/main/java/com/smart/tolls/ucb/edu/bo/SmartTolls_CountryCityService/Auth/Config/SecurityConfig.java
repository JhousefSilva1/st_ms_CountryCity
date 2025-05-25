package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.Config;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.JwtAuthEntryPoint;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.JwtAuthenticationFilter;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.Service.JwtService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Auth.Service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthEntryPoint authEntryPoint;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthEntryPoint authEntryPoint,
                          JwtService jwtService,
                          UserDetailsService userDetailsService) {
        this.authEntryPoint = authEntryPoint;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(authEntryPoint))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
//                        for country
                                .requestMatchers(HttpMethod.GET,"/api/country/all").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/country").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/country/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/country/create").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/country/update").hasAuthority("ADMINISTRADOR")
                                .requestMatchers(HttpMethod.DELETE, "/api/country/delete").hasAuthority("ADMINISTRADOR")
//                        for city
                                .requestMatchers(HttpMethod.GET,"/api/city/all").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/city").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/city/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/city/create").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/city/update").hasRole("ADMINISTRADOR")
                                .requestMatchers(HttpMethod.DELETE,"/api/city/delete").hasRole("ADMINISTRADOR")
//                        City by CountryId
                                .requestMatchers(HttpMethod.GET,"/api/city/country/{id}").permitAll()
//                        Place by CityId
                                .requestMatchers(HttpMethod.GET,"/api/places/city/{id}").permitAll()
//                        Tolls by PlaceId
                                .requestMatchers(HttpMethod.GET,"/api/toll/place/{id}").permitAll()
//                        for places
                                .requestMatchers(HttpMethod.GET,"/api/places/all").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/places").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/places/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/places/create").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/places/update").hasRole("ADMINISTRADOR")
                                .requestMatchers(HttpMethod.DELETE,"/api/places/delete").hasRole("ADMINISTRADOR")
//                        for road type
                                .requestMatchers(HttpMethod.GET,"/api/roadType/all").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/roadType").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/roadType/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/roadType/create").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/roadType/update").hasRole("ADMINISTRADOR")
                                .requestMatchers(HttpMethod.DELETE,"/api/roadType/delete").hasRole("ADMINISTRADOR")
//                        for tolls
                                .requestMatchers(HttpMethod.GET,"/api/toll/all").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/toll").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/toll/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/toll/create").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/toll/update").hasRole("ADMINISTRADOR")
                                .requestMatchers(HttpMethod.DELETE,"/api/toll/delete").hasRole("ADMINISTRADOR")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService, (UserDetailsServiceImpl) userDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}