package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.dto.BookDTO;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public List<Book> getAllBooks() {
//        return bookService.getAllBooks();
//    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<BookDTO> getAllBooks() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        return bookService.updateBook(id, bookDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
