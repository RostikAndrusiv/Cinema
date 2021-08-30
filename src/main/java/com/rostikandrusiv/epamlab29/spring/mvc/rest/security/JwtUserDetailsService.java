package com.rostikandrusiv.epamlab29.spring.mvc.rest.security;


import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.UserRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

@Autowired
    private UserRepository userRepository;

    @Override
    public JwtUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        return JwtUser.fromUserToJwtUser(user);
    }
}
