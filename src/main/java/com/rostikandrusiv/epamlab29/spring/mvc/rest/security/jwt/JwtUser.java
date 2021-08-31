package com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@Slf4j
public class JwtUser implements UserDetails {
    private long id;
    private String login;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static JwtUser fromUserToJwtUser(User user) {
        JwtUser jwtUser = new JwtUser();
        jwtUser.id = user.getId();
        jwtUser.login = user.getLogin();
        jwtUser.email = user.getEmail();
        jwtUser.password= user.getPassword();
        jwtUser.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        return jwtUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
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
