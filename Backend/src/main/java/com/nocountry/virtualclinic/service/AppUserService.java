//package com.nocountry.virtualclinic.service;
//
//import com.nocountry.virtualclinic.domain.user.AppUser;
//import com.nocountry.virtualclinic.domain.user.AppUserRepository;
<<<<<<< HEAD
//import com.nocountry.virtualclinic.domain.user.DatosAutenticacionUsuario;
=======
>>>>>>> 3e96cd65faf288feea246b02c8f518ee2d784d8a
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
<<<<<<< HEAD
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        AppUser appUser = (AppUser) repository.findByLogin(login);
=======
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        AppUser appUser = repository.findByEmail(email);
>>>>>>> 3e96cd65faf288feea246b02c8f518ee2d784d8a
//
//        if (appUser == null) {
//            throw new UsernameNotFoundException("User Not Found");
//        }
<<<<<<< HEAD
//        return User.withUsername(appUser.getLogin())
//                .password(appUser.getClave())
=======
//        return User.withUsername(appUser.getEmail())
//                .password(appUser.getPassword())
//                .roles(appUser.getRole())
>>>>>>> 3e96cd65faf288feea246b02c8f518ee2d784d8a
//                .build();
//    }
//}
//
