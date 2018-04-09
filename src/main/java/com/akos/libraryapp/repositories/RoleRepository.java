package com.akos.libraryapp.repositories;

import com.akos.libraryapp.domain.entity.security.Authority;
import com.akos.libraryapp.domain.entity.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Authority, Long> {

    Authority findByName(AuthorityName role);
}
