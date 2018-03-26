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
        steev.setPhotoURL("https://pbs.twimg.com/profile_images/378800000836981162/b683f7509ec792c3e481ead332940cdc.jpeg");
        steev.setBiography("Stephen Edwin King is an American author of horror, supernatural fiction, suspense, science" +
                " fiction, and fantasy. His books have sold more than 350 million copies, many of which have been adapted " +
                "into feature films, miniseries, television series, and comic books. King has published 54 novels, including " +
                "seven under the pen name Richard Bachman, and six non-fiction books. He has written around 200 short" +
                " stories, most of which have been collected in book collections.\n" +
                "King has received Bram Stoker Awards, World Fantasy Awards, and British Fantasy Society Awards. In 2003," +
                " the National Book Foundation awarded him the Medal for Distinguished Contribution to American " +
                "Letters.He has also received awards for his contribution to literature for his entire oeuvre, such as" +
                " the World Fantasy Award for Life Achievement (2004), and the Grand Master Award from the Mystery" +
                " Writers of America (2007). In 2015, King was awarded with a National Medal of Arts from the United" +
                " States National Endowment for the Arts for his contributions to literature. He has been described " +
                "as the \"King of Horror\".\n");

        Author robert = new Author();
        robert.setFullName("R.A. Salvatore");
        robert.setBirthday(new Date(calendar.getTime().getTime()));

        Author howard = new Author();
        howard.setFullName("H.P. Lovecraft ");
        calendar.set(1890, Calendar.MARCH, 20);
        howard.setBirthday(new Date(calendar.getTime().getTime()));

        Author frank = new Author();
        frank.setFullName("Frank Herbert");
        calendar.set(1986, Calendar.OCTOBER, 8);
        frank.setBirthday(new Date(calendar.getTime().getTime()));

        Author george  = new Author();
        george.setFullName("George Orwell");
        calendar.set(1903, Calendar.JUNE, 25);
        george.setBirthday(new Date(calendar.getTime().getTime()));

        Author doug = new Author();
        doug.setFullName("Douglas Adams");
        calendar.set(1952, Calendar.MARCH, 11);
        doug.setBirthday(new Date(calendar.getTime().getTime()));


        Genre horror = new Genre("Horror");

        Genre fantasy = new Genre("Fantasy");

        Genre sciFi = new Genre("Sci-fi");

        Genre comedy = new Genre("Comedy");

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
        book3.setImageURL("https://s-media-cache-ak0.pinimg.com/originals/ac/f9/56/acf95607f3684997f9ef1f4fac7d3326.jpg");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book4 = new Book("Sea of Swords");
        book4.getAuthors().add(robert);
        book4.setGenre(fantasy);
        book4.setPublishYear(2001);
        book4.setImageURL("https://vignette.wikia.nocookie.net/forgottenrealms/images/b/be/Sea_of_Swords.jpg/revision/latest?cb=20070219001247");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book5 = new Book("The Dream-Quest of Unknown Kadath");
        book5.getAuthors().add(howard);
        book5.setGenre(fantasy);
        book5.setPublishYear(1943);
        book5.setImageURL("https://upload.wikimedia.org/wikipedia/en/5/55/The-Dream-Quest-of-Unknown-Kadath.jpg");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book6 = new Book("Dune");
        book6.getAuthors().add(frank);
        book6.setGenre(sciFi);
        book6.setPublishYear(1963);
        book6.setImageURL("https://i.pinimg.com/originals/1e/6f/6f/1e6f6fdedbdd9ab1ed3dc1a107a1b87e.jpg");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book7 = new Book("1984");
        book7.getAuthors().add(george);
        book7.setGenre(sciFi);
        book7.setPublishYear(1949);
        book7.setImageURL("https://s-media-cache-ak0.pinimg.com/originals/6f/cf/76/6fcf76874ffe4ba02a7c23fac931d17c.jpg");

        Book book8 = new Book("The Hitchhiker's Guide to the Galaxy");
        book8.getAuthors().add(doug);
        book8.setGenre(comedy);
        book8.setPublishYear(1979);
        book8.setImageURL("https://vignette.wikia.nocookie.net/hitchhikers/images/1/11/The_Hitchhiker%27s_Guide_to_the_Galaxy.jpg/revision/latest?cb=20140520174710");


        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
        bookService.save(book6);
        bookService.save(book7);
        bookService.save(book8);

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