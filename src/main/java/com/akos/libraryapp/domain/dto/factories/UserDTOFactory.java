package com.akos.libraryapp.domain.dto.factories;

import com.akos.libraryapp.domain.dto.UserDTO;
import com.akos.libraryapp.domain.entity.security.User;

public class UserDTOFactory {

    public UserDTOFactory() {
    }

    public static UserDTO create(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAuthorities(user.getAuthorities());
        userDTO.setLastPasswordResetDate(user.getLastPasswordResetDate());
        userDTO.setPassword(user.getPassword());
        userDTO.setEnabled(user.getEnabled());

        return userDTO;
    }
}
