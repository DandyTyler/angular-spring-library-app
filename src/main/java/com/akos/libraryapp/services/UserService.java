package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.entity.security.User;
import com.akos.libraryapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User disableUser(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        user.setEnabled(false);
        userRepository.save(user);
        return user;
    }

    public User enableUser(String username) {

        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        user.setEnabled(true);
        userRepository.save(user);
        return user;
    }

    public User getUser(String username){
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        return user;
    }
}
