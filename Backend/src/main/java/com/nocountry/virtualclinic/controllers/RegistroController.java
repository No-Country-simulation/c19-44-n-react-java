package com.nocountry.virtualclinic.controllers;

import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.DatosRegistroUsuario;
import com.nocountry.virtualclinic.domain.user.AppUserRepository;
import com.nocountry.virtualclinic.domain.user.DatosRespuestaUsuario;
import com.nocountry.virtualclinic.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistroController {

    @Autowired
    private AppUserRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/signup")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario (@Valid @RequestBody DatosRegistroUsuario datosRegistroUsuario){
        AppUser user = usuarioService.registroUsuario(datosRegistroUsuario);
        return new ResponseEntity<>(new DatosRespuestaUsuario(user.getNombreUsuario(), user.getLogin()), HttpStatus.CREATED);
    }

}
