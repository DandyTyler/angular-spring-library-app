package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.entity.Genre;
import com.akos.libraryapp.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/genres")
public class GenreController {

    private GenreRepository repository;

    @Autowired
    public GenreController(GenreRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Genre> getAuthors(){
        return repository.findAll();
    }
}
