package com.nocountry.virtualclinic.service;

import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.AppUserRepository;
import com.nocountry.virtualclinic.domain.user.DatosRegistroUsuario;
import com.nocountry.virtualclinic.domain.user.DatosRespuestaUsuario;
import com.nocountry.virtualclinic.infra.errores.EmailAlreadyInUseException;
import com.nocountry.virtualclinic.infra.errores.PasswordsDoNotMatchException;
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
        if (!datosRegistroUsuario.clave().equals(datosRegistroUsuario.confirmaClave())) {
            throw new PasswordsDoNotMatchException("Tu clave no coincide");
        }
        Optional<AppUser> optionalAppUser = repository.findByLogin(datosRegistroUsuario.login());
        if (optionalAppUser.isPresent()) {
            throw new EmailAlreadyInUseException("Tu clave no coincide");
        }

        AppUser newUser = new AppUser(datosRegistroUsuario.login(), bCryptEncoder.encode(datosRegistroUsuario.clave()), datosRegistroUsuario.nombreUsuario());
        repository.save(newUser);
        return newUser;
    }

}
