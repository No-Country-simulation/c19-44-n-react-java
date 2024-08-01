package com.nocountry.virtualclinic.controllers;


import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.DatosAutenticacionUsuario;
import com.nocountry.virtualclinic.infra.security.config.DatosJWTToken;
import com.nocountry.virtualclinic.infra.security.config.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        try {
            userDetailsService.loadUserByUsername(datosAutenticacionUsuario.login());
            String jwtToken = tokenService.generarToken(datosAutenticacionUsuario.login());

            return ResponseEntity.ok(new DatosJWTToken(jwtToken));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new DatosJWTToken("Autenticación fallida: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new DatosJWTToken("Error interno del servidor: " + e.getMessage()));
        }
    }

}


