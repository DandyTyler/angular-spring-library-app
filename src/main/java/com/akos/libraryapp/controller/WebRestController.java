package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Genre;
import com.akos.libraryapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
public class WebRestController {

    private Logger log = LoggerFactory.getLogger(WebRestController.class);

    private BookService bookService;

    @Autowired
    public WebRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/hi")
    public String hi() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(1947, Calendar.SEPTEMBER, 21);


        Author steev = new Author();
        steev.setFullName("Stephen King");
        steev.setBirthday(new Date(calendar.getTime().getTime()));

        Author robert = new Author();
        robert.setFullName("R.A.Salvatore");
        robert.setBirthday(new Date(calendar.getTime().getTime()));

        Author howard = new Author();
        howard.setFullName("H.P.Lovecraft ");
        calendar.set(1890, Calendar.MARCH, 20);
        howard.setBirthday(new Date(calendar.getTime().getTime()));

        Genre horror = new Genre("Horror");

        Genre fantasy = new Genre("Fantasy");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book1 = new Book("It");
        book1.getAuthors().add(steev);
        book1.setGenre(horror);
        book1.setPublishYear(1986);
        book1.setImageURL("https://i.pinimg.com/originals/11/c1/8f/11c18fbb50b3abe089e5f519cc1988cb.png");
        book1.setDescription("Description");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book2 = new Book("The Shining");
        book2.getAuthors().add(steev);
        book2.setGenre(horror);
        book2.setPublishYear(1977);
        book2.setImageURL("http://assets-cdn.shortlist.com/app/uploads/2012/06/24225210/30-most-evil-lines-from-books-3.jpg");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book3 = new Book("Icewind Dale");
        book3.getAuthors().add(robert);
        book3.setGenre(fantasy);
        book3.setPublishYear(1988);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book4 = new Book("Sea of Swords");
        book4.getAuthors().add(robert);
        book4.setGenre(fantasy);
        book4.setPublishYear(2001);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book5 = new Book("The Dream-Quest of Unknown Kadath");
        book5.getAuthors().add(howard);
        book5.setGenre(fantasy);
        book5.setPublishYear(1943);
        book5.setImageURL("https://upload.wikimedia.org/wikipedia/en/5/55/The-Dream-Quest-of-Unknown-Kadath.jpg");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);

        log.info("All books:");
        log.info("-------------------------------");
        for (Book book : bookService.getAllBooks()) {
            log.info(book.toString());
        }
        log.info("");


        log.info("Find book by name (It):");
        log.info("-------------------------------");

        log.info( bookService.getBookByName("It").toString());

        log.info("");

        return "Init successful!";
    }
}