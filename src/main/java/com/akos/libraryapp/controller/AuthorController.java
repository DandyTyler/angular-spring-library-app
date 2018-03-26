package com.akos.libraryapp.controller;


import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/authors")
public class AuthorController {

    private AuthorRepository repository;

    @Autowired
    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAuthors(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable("id") Long id){
        return repository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        return repository.save(author);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Author updateAuthor(@RequestBody Author author){
        return repository.save(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Author updateBook(@PathVariable Long id, @RequestBody Author author) {
        return repository.save(author);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable Long id){
         repository.deleteById(id);
    }
}
