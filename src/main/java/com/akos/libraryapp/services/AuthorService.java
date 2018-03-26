package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

}
