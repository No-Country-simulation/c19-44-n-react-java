package com.nocountry.virtualclinic.service;

import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.AppUserRepository;
import com.nocountry.virtualclinic.domain.user.DatosRegistroUsuario;
import com.nocountry.virtualclinic.domain.user.DatosRespuestaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private AppUserRepository repository;

    BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();


    @Transactional
    public AppUser registroUsuario(DatosRegistroUsuario datosRegistroUsuario) {
        //probrar registrando un email existente para ver el tipo de exception que devuelve
//        Optional<AppUser> optionalAppUser = repository.findByLogin(datosRegistroUsuario.login());
//        if (optionalAppUser.isPresent()) {
//            result.addError(new FieldError("datosRegistroUsuario", "login", "Ese email ya se encuentra en uso."));
//        }
        AppUser newUser = new AppUser(datosRegistroUsuario.login(), bCryptEncoder.encode(datosRegistroUsuario.clave()));
        repository.save(newUser);
        return newUser;
    }

}
