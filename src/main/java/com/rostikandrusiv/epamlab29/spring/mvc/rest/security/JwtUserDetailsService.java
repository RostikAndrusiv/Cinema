package com.rostikandrusiv.epamlab29.spring.mvc.rest.security;


import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.security.jwt.JwtUser;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public JwtUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = UserMapper.INSTANCE.toUser(userService.getUser(login));
        return JwtUser.fromUserToJwtUser(user);
    }
}
