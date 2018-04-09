package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.dto.UserDTO;
import com.akos.libraryapp.domain.dto.factories.UserDTOFactory;
import com.akos.libraryapp.domain.entity.security.Authority;
import com.akos.libraryapp.domain.entity.security.AuthorityName;
import com.akos.libraryapp.domain.entity.security.User;
import com.akos.libraryapp.repositories.RoleRepository;
import com.akos.libraryapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getAll() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userDTOList.add(UserDTOFactory.create(user));
        }
        return userDTOList;
    }

    public UserDTO disableUser(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        user.setEnabled(false);
        userRepository.save(user);
        return UserDTOFactory.create(user);
    }

    public UserDTO enableUser(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        user.setEnabled(true);
        userRepository.save(user);
        return UserDTOFactory.create(user);
    }

    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        return UserDTOFactory.create(user);
    }

    public UserDTO updateUser(String username, User updatedUser) {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());

        if (updatedUser.getPassword()!=null&&!user.getPassword().equals(updatedUser.getPassword())) {
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            user.setLastPasswordResetDate(new Date());
        }

        return UserDTOFactory.create(userRepository.save(user));
    }

    public UserDTO saveUser(User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserCreationException("User with this username is already exists");
    }

        List<Authority> authorities = new ArrayList<>();
        authorities.add(roleRepository.findByName(AuthorityName.ROLE_USER));
        user.setAuthorities(authorities);

        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setLastPasswordResetDate(new Date());

//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        List<Authority> authorities = new ArrayList<>();
//        authorities.add(roleRepository.findByName(AuthorityName.ROLE_USER));
//        user.setAuthorities(authorities);
//        user.setLastPasswordResetDate(new Date());

        System.out.println(user.getId());


        return UserDTOFactory.create(userRepository.save(user));
    }
}
