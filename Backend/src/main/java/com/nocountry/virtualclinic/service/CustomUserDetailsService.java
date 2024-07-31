package com.nocountry.virtualclinic.service;

import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Cargando detalles del usuario para: {}", username);
        AppUser user = userRepository.findByLogin(username)
                .orElseThrow(() -> {
                    logger.error("Usuario no encontrado con el nombre de usuario: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });

        logger.info("Detalles del usuario cargados: {}", user.getUsername());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, new ArrayList<>());
    }

    public Long getUsuarioId(String username) {
        AppUser user = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return user.getUsuarioId();
    }

}