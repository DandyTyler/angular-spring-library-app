package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Genre;
import com.akos.libraryapp.domain.entity.security.Authority;
import com.akos.libraryapp.domain.entity.security.AuthorityName;
import com.akos.libraryapp.domain.entity.security.User;
import com.akos.libraryapp.repositories.UserRepository;
import com.akos.libraryapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class WebRestController {

    private Logger log = LoggerFactory.getLogger(WebRestController.class);

    private BookService bookService;

    private UserRepository userRepository;

    @Autowired
    public WebRestController(BookService bookService, UserRepository userRepository) {
        this.bookService = bookService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/api/hi")
    public String hi() {

        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthorityName.ROLE_ADMIN);

        Authority userAuthority = new Authority();
        userAuthority.setName(AuthorityName.ROLE_USER);

        List<Authority> authoritiesAdmin = new ArrayList<>();
        authoritiesAdmin.add(userAuthority);
        authoritiesAdmin.add(adminAuthority);

        User admin = new User();
        admin.setAuthorities(authoritiesAdmin);
        admin.setEnabled(true);
        admin.setUsername("admin");
        admin.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@admin.com");
        admin.setLastPasswordResetDate(new Date());

        List<Authority> authoritiesUser = new ArrayList<>();
        authoritiesUser.add(userAuthority);

        User user = new User();
        user.setAuthorities(authoritiesUser);
        user.setEnabled(true);
        user.setUsername("user");
        user.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
        user.setFirstName("user");
        user.setLastName("user");
        user.setEmail("enabled@user.com");
        user.setLastPasswordResetDate(new Date());

        User disabledUser = new User();
        disabledUser.setAuthorities(authoritiesUser);
        disabledUser.setEnabled(false);
        disabledUser.setUsername("disabled");
        disabledUser.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
        disabledUser.setFirstName("user");
        disabledUser.setLastName("user");
        disabledUser.setEmail("disabled@user.com");
        disabledUser.setLastPasswordResetDate(new Date());

        userRepository.save(admin);
        userRepository.save(user);
        userRepository.save(disabledUser);

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
        book1.setDescription("It is a 1986 horror novel by American author Stephen King. It was his 22nd book, and his " +
                "18th novel written under his own name. The story follows the experiences of seven children as they are" +
                " terrorized by an entity that exploits the fears and phobias of its victims to disguise itself while" +
                " hunting its prey. \"It\" primarily appears in the form of a clown to attract its preferred prey " +
                "of young children.\n" +
                "The novel is told through narratives alternating between two periods, and is largely told in the" +
                " third-person omniscient mode. It deals with themes that eventually became King staples: the power" +
                " of memory, childhood trauma and its recurrent echoes in adulthood, the ugliness lurking behind a" +
                " façade of small-town quaintness, and overcoming evil through mutual trust and sacrifice.\n" +
                "King has stated that he first conceived the story in 1978, and began writing it in 1981. He also" +
                " stated that he originally wanted the title character to be a troll like the one in the children's " +
                "story Three Billy Goats Gruff, but who inhabited the local sewer system rather than just the area" +
                " beneath one bridge. He also wanted the story to interweave the stories of children and the adults " +
                "they later become.\n" +
                "The novel won the British Fantasy Award in 1987, and received nominations for the Locus and World " +
                "Fantasy Awards that same year.Publishers Weekly listed It as the best-selling book in the United States " +
                "in 1986.[citation needed] It has been adapted into a 1990 two-part miniseries directed by Tommy " +
                "Lee Wallace, and into a 2017 film and its 2019 sequel directed by Andy Muschietti.\n");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Book book2 = new Book("The Shining");
        book2.getAuthors().add(steev);
        book2.setGenre(horror);
        book2.setPublishYear(1977);
        book2.setImageURL("http://assets-cdn.shortlist.com/app/uploads/2012/06/24225210/30-most-evil-lines-from-books-3.jpg");
        book2.setDescription("The Shining is a horror novel by American author Stephen King. Published in 1977, " +
                "it is King's third published novel and first hardback bestseller: the success of the book firmly" +
                " established King as a preeminent author in the horror genre. The setting and characters are " +
                "influenced by King's personal experiences, including both his visit to The Stanley Hotel in 1974 and his recovery from alcoholism. The novel was followed by a sequel, Doctor Sleep, published in 2013.\n" +
                "\n" +
                "The Shining centers on the life of Jack Torrance, an aspiring writer and recovering alcoholic who " +
                "accepts a position as the off-season caretaker of the historic Overlook Hotel in the Colorado" +
                " Rockies. His family accompanies him on this job, including his young son Danny Torrance, who" +
                " possesses \"the shining\", an array of psychic abilities that allow Danny to see the hotel's" +
                " horrific past. Soon, after a winter storm leaves them snowbound, the supernatural forces inhabiting" +
                " the hotel influence Jack's sanity, leaving his wife and son in incredible danger.\n" +
                "\n" +
                "The novel was adapted into a 1980 feature film of the same name directed by Stanley Kubrick and" +
                " co-written with Diane Johnson. Although King himself remains disappointed with the adaptation," +
                " having criticized its handling of the book's themes and of Wendy's character, it is regarded as" +
                " one of the greatest horror films ever made. A television mini-series later premiered in 1997, with" +
                "the making closely monitored by King to ensure it had followed the novel's narrative. King wrote the" +
                " series himself and was reportedly unable to criticize the Kubrick version due to his contract.\n");

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