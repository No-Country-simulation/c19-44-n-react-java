//package com.nocountry.virtualclinic.infra.security.config;
//
//import com.nocountry.virtualclinic.domain.user.AppUser;
//import com.nocountry.virtualclinic.domain.user.AppUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AutenticacionService implements UserDetailsService {
//
//    @Autowired
//    private AppUserRepository appUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        UserDetails appUser = appUserRepository.findByLogin(login);
//
//        if (appUser == null) {
//            throw new UsernameNotFoundException("Usuario no encontrado");
//        }
//        return new AppUser(appUser.getUsername(), appUser.getPassword());
//    }
//}
