package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.dto.BookDTO;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Vote;
import com.akos.libraryapp.services.BookService;
import com.akos.libraryapp.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "api/books")
public class BookController {
    private BookService bookService;

    private VoteService voteService;

    @Autowired
    public BookController(BookService bookService, VoteService voteService) {
        this.bookService = bookService;
        this.voteService = voteService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<BookDTO> getAllBooks() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return bookService.getById(id);
    }


    @RequestMapping(value = "/{id}/votes", method = RequestMethod.GET)
    public List<Vote> getVotes(@PathVariable Long id) {
        return voteService.getBookVotes(id);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @PreAuthorize("hasRole('ADMIN')")
//    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
//        return bookService.createBook(bookDTO);
//    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json", consumes = {"multipart/form-data"})
    @PreAuthorize("hasRole('ADMIN')")
    public BookDTO createBook(@RequestPart("content") MultipartFile content, @RequestPart("book") BookDTO bookDTO) {

        return bookService.createBook(content, bookDTO);
    }

    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET, produces = "application/pdf")
    public byte[] getPdf(@PathVariable Long id) {
        return bookService.getById(id).getContent();
    }

    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    @PreAuthorize("hasRole('ADMIN')")
    public void updatePdf(@PathVariable Long id, @RequestPart("content") MultipartFile content) {
        bookService.updateContent(id, content);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        return bookService.updateBook(id, bookDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
