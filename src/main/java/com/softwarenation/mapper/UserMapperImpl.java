package com.softwarenation.mapper;

import com.softwarenation.api.dto.UserDTO;
import com.softwarenation.domen.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setSurname(user.getSurname());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public User userDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        return user;
    }


    public Set<User> usersDtoToUsers(Set<UserDTO> userDTOSet) {
        return userDTOSet.stream().map(userDto -> userDtoToUser(userDto)).collect(Collectors.toSet());
    }
}