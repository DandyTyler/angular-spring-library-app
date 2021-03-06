package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.dto.AuthorDTO;
import com.akos.libraryapp.domain.dto.BookDTO;
import com.akos.libraryapp.domain.dto.GenreDTO;
import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Genre;
import com.akos.libraryapp.repositories.AuthorRepository;
import com.akos.libraryapp.repositories.BookRepository;
import com.akos.libraryapp.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private static final int PAGE_SIZE = 10;

    private BookRepository bookRepository;

    private GenreRepository genreRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Page<Book> getAllBooks(Pageable pageRequest) {
        return bookRepository.findAll(pageRequest);
    }

    public Page<Book> findByNameAndGenre(String nameSearchTerm, Long genreId, Pageable pageRequest){

        if(genreId!=null&&nameSearchTerm!=null){
            return bookRepository.findAllByNameIgnoreCaseContainsAndGenre_Id(nameSearchTerm, genreId, pageRequest);
        }

        if(genreId==null&&nameSearchTerm!=null){
            return bookRepository.findAllByNameIgnoreCaseContains(nameSearchTerm, pageRequest);
        }

        if(genreId!=null){
            return bookRepository.findAllByGenre_Id(genreId, pageRequest);
        }

        return bookRepository.findAll(pageRequest);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Book getBookByName(String bookName) {
        return bookRepository.findByName(bookName);
    }

    public Book getById(Long id) {
        return bookRepository.getOne(id);
    }

    public List<Book> getBy(Genre genre) {
        return bookRepository.findAllByGenre(genre);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {

        Book newBook = new Book(bookDTO.getName());

        Genre genre = genreRepository.getOne(bookDTO.getGenre().getId());

        newBook.setGenre(genre);

        newBook.setPublishYear(bookDTO.getPublishYear());

        newBook.setImageURL(bookDTO.getImageURL());

        newBook.setDescription(bookDTO.getDescription());

        newBook.setQuantity(bookDTO.getQuantity());

        for (AuthorDTO authorDTO: bookDTO.getAuthors()) {

            Author author = authorRepository.getOne(authorDTO.getId());

            newBook.getAuthors().add(author);
        }

        bookDTO.setId(bookRepository.save(newBook).getId());

        return bookDTO;
    }

    public BookDTO createBook(MultipartFile content, BookDTO bookDTO) {

        Book newBook = new Book(bookDTO.getName());

        Genre genre = genreRepository.getOne(bookDTO.getGenre().getId());

        newBook.setGenre(genre);

        newBook.setPublishYear(bookDTO.getPublishYear());

        newBook.setImageURL(bookDTO.getImageURL());

        newBook.setDescription(bookDTO.getDescription());

        newBook.setQuantity(bookDTO.getQuantity());

        try {
            newBook.setContent(content.getBytes());
        } catch (IOException e) {
           throw new RuntimeException(e);
        }

        for (AuthorDTO authorDTO: bookDTO.getAuthors()) {

            Author author = authorRepository.getOne(authorDTO.getId());

            newBook.getAuthors().add(author);
        }

        bookDTO.setId(bookRepository.save(newBook).getId());

        return bookDTO;
    }

    public List<BookDTO> getAll() {

        List<BookDTO> bookList = new ArrayList<>();

        for (Book book : bookRepository.findAll()) {

            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setName(book.getName());
            bookDTO.setPublishYear(book.getPublishYear());
            bookDTO.setImageURL(book.getImageURL());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setRating(book.getRating());
            bookDTO.setQuantity(book.getQuantity());

            GenreDTO genreDTO = new GenreDTO();
            genreDTO.setId(book.getGenre().getId());
            genreDTO.setName(book.getGenre().getName());
            bookDTO.setGenre(genreDTO);

            Set<AuthorDTO> authorsList = new HashSet<>();

            for (Author author : book.getAuthors()) {
                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setId(author.getId());
                authorDTO.setBirthday(author.getBirthday());
                authorDTO.setFullName(author.getFullName());

                authorsList.add(authorDTO);
            }

            bookDTO.setAuthors(authorsList);

            bookList.add(bookDTO);
        }

        return bookList;
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {

        Book updatedBook = bookRepository.getOne(id);

        Genre genre = genreRepository.getOne(bookDTO.getGenre().getId());

        updatedBook.setGenre(genre);

        updatedBook.setPublishYear(bookDTO.getPublishYear());

        updatedBook.setDescription(bookDTO.getDescription());

        updatedBook.setImageURL(bookDTO.getImageURL());

        updatedBook.setQuantity(bookDTO.getQuantity());

        Set<Author> updatedAuthors = new HashSet<>();

        for (AuthorDTO authorDTO: bookDTO.getAuthors()) {

            Author author = authorRepository.getOne(authorDTO.getId());

            updatedAuthors.add(author);
        }

        updatedBook.setAuthors(updatedAuthors);

        bookRepository.save(updatedBook);

        bookDTO.setId(id);

        return bookDTO;
    }

    public void updateContent(Long id, MultipartFile content){

        Book book = bookRepository.getOne(id);
        System.out.println(book.getName());
        try {
            book.setContent(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
