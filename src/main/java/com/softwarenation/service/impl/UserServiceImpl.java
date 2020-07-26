package com.softwarenation.service.impl;

import com.softwarenation.api.dto.UserDTO;
import com.softwarenation.domen.Role;
import com.softwarenation.domen.User;
import com.softwarenation.enums.RoleName;
import com.softwarenation.mapper.UserMapperImpl;
import com.softwarenation.repository.UserRepository;
import com.softwarenation.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapperImpl userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) throw new EntityNotFoundException("There is no user with this username.");
        UserDTO userDTO =  userMapper.userToUserDTO(user);
        return userDTO;
    }

    @Override
    @Transactional
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    @Transactional
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @GetMapping
    public Set<UserDTO> getAllUsersWithRoleUSER() {
          Role role = new Role();
          role.setName(RoleName.ROLE_USER);
        List<User> userbyRoles = userRepository.findUserByRoles("ROLE_USER");
        Set<User>  usersSet= new HashSet<>(userbyRoles);
        Set<UserDTO> userDTOSet = new HashSet<>();
        userDTOSet = usersSet.stream().map(userMapper::userToUserDTO).collect(Collectors.toSet());
        return userDTOSet;
    }
}