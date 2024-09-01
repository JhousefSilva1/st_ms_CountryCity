package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.config;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StPersonRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StPersonRepository stPersonRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        StPersonEntity stPersonEntity = stPersonRepository.findByEmail(email) .orElseThrow(() ->
                new UsernameNotFoundException("User not exists by Username or Email"));

        Set<GrantedAuthority> authorities = stPersonEntity.getPersonTypes().stream()
                .map((personType) -> new SimpleGrantedAuthority(personType.getStPersonType()))
                .collect(Collectors.toSet());

        return new User(
                email,
                stPersonEntity.getPasswords(),
                authorities
        );
    }
}