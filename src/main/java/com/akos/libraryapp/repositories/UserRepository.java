package com.akos.libraryapp.repositories;

import com.akos.libraryapp.domain.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
