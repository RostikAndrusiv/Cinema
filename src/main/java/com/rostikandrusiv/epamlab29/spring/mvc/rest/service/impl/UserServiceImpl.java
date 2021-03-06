package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.UserDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.EmailAlreadyUsedException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.LoginAlreadyUsedException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.UserNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Role;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.User;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.RoleRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.UserRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.UserService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto getUser(long id) {
        log.info("getUser by id {} ", id);
        User user = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("getAllMovies");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with name {} ", userDto.getLogin());
        if (userRepository.existsByLogin(userDto.getLogin())) {
            throw new LoginAlreadyUsedException();
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyUsedException();
        }
        User user = userMapper.toUser(userDto);
        Role userRole = roleRepository.findByname("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto findByLoginAndPassword(String login, String password) {
        log.info("findUser with name {} ", login);
        User user = userRepository.findByLogin(login);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        return null;
    }


    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        log.info("updateUser with id {} ", id);
        User persistedUser = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        User storedUser = userRepository.save(persistedUser);
        log.info("User with {} name was successfully updated", storedUser.getLogin());
        return userMapper.toUserDto(persistedUser);
    }

    @Override
    public void deleteUser(long id) {
        log.info("deleteUser with id {} ", id);
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}

