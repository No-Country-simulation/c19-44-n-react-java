//package com.nocountry.virtualclinic.service;
//
//import com.nocountry.virtualclinic.domain.user.AppUser;
//import com.nocountry.virtualclinic.domain.user.AppUserRepository;
//import com.nocountry.virtualclinic.domain.user.DatosAutenticacionUsuario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AppUserService implements UserDetailsService {
//    @Autowired
//    private AppUserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        AppUser appUser = (AppUser) repository.findByLogin(login);
//
//        if (appUser == null) {
//            throw new UsernameNotFoundException("User Not Found");
//        }
//        return User.withUsername(appUser.getLogin())
//                .password(appUser.getClave())
//                .build();
//    }
//}
//
