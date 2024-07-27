package com.nocountry.virtualclinic.domain.user;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity(name= "User")
@Table(name = "usuarios")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "usuario", unique = true, nullable = false)
    private String login;

    private String clave;

    public AppUser(String username, String password) {
        this.login = username;
        this.clave= password;
    }


    //Métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}




//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//
//    private String firstName;
//    private String lastName;
//
//    @Column (unique = true, nullable = false)
//    private String email;
//
//    private String phone;
//    private String password;
//    private String role;
//    private Date createdAt; //Date de java.util


