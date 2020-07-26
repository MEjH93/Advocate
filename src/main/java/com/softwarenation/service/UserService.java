package com.softwarenation.service;

import com.softwarenation.api.dto.UserDTO;
import com.softwarenation.domen.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    UserDTO getUserByUsername(String auth);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Set<UserDTO> getAllUsersWithRoleUSER();

}