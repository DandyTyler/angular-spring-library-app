INSERT INTO PUBLIC.AUTHORITY (ID, NAME) VALUES (2, 'ROLE_USER');
INSERT INTO PUBLIC.AUTHORITY (ID, NAME) VALUES (3, 'ROLE_ADMIN');

INSERT INTO PUBLIC.USERS (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (1, 'admin@admin.com', true, 'admin', 'admin', '2018-04-06 20:24:25.702000000', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin');
INSERT INTO PUBLIC.USERS (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (4, 'enabled@user.com', true, 'user', 'user', '2018-04-06 20:24:25.702000000', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user');
INSERT INTO PUBLIC.USERS (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (5, 'disabled@user.com', false, 'user', 'user', '2018-04-06 20:24:25.702000000', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'disabled');

INSERT INTO PUBLIC.USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO PUBLIC.USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 3);
INSERT INTO PUBLIC.USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (4, 2);
INSERT INTO PUBLIC.USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (5, 2);

INSERT INTO PUBLIC.GENRE (ID, NAME) VALUES (7, 'Horror');
INSERT INTO PUBLIC.GENRE (ID, NAME) VALUES (11, 'Fantasy');
INSERT INTO PUBLIC.GENRE (ID, NAME) VALUES (17, 'Sci-fi');
INSERT INTO PUBLIC.GENRE (ID, NAME) VALUES (22, 'Comedy');

INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (8, 'Stephen Edwin King is an American author of horror, supernatural fiction, suspense, science fiction, and fantasy. His books have sold more than 350 million copies, many of which have been adapted into feature films, miniseries, television series, and comic books. King has published 54 novels, including seven under the pen name Richard Bachman, and six non-fiction books. He has written around 200 short stories, most of which have been collected in book collections.
King has received Bram Stoker Awards, World Fantasy Awards, and British Fantasy Society Awards. In 2003, the National Book Foundation awarded him the Medal for Distinguished Contribution to American Letters.He has also received awards for his contribution to literature for his entire oeuvre, such as the World Fantasy Award for Life Achievement (2004), and the Grand Master Award from the Mystery Writers of America (2007). In 2015, King was awarded with a National Medal of Arts from the United States National Endowment for the Arts for his contributions to literature. He has been described as the "King of Horror".
', '1947-09-21 20:24:25.790000000', 'Stephen King', 'https://pbs.twimg.com/profile_images/378800000836981162/b683f7509ec792c3e481ead332940cdc.jpeg');
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (12, null, '1947-09-21 20:24:25.790000000', 'R.A. Salvatore', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (15, null, '1890-03-20 20:24:25.790000000', 'H.P. Lovecraft ', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (18, null, '1986-10-08 20:24:25.790000000', 'Frank Herbert', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (20, null, '1903-06-25 20:24:25.790000000', 'George Orwell', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (23, null, '1952-03-11 20:24:25.790000000', 'Douglas Adams', null);

INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (6, null, 'It is a 1986 horror novel by American author Stephen King. It was his 22nd book, and his 18th novel written under his own name. The story follows the experiences of seven children as they are terrorized by an entity that exploits the fears and phobias of its victims to disguise itself while hunting its prey. "It" primarily appears in the form of a clown to attract its preferred prey of young children.
The novel is told through narratives alternating between two periods, and is largely told in the third-person omniscient mode. It deals with themes that eventually became King staples: the power of memory, childhood trauma and its recurrent echoes in adulthood, the ugliness lurking behind a façade of small-town quaintness, and overcoming evil through mutual trust and sacrifice.
King has stated that he first conceived the story in 1978, and began writing it in 1981. He also stated that he originally wanted the title character to be a troll like the one in the children''s story Three Billy Goats Gruff, but who inhabited the local sewer system rather than just the area beneath one bridge. He also wanted the story to interweave the stories of children and the adults they later become.
The novel won the British Fantasy Award in 1987, and received nominations for the Locus and World Fantasy Awards that same year.Publishers Weekly listed It as the best-selling book in the United States in 1986.[citation needed] It has been adapted into a 1990 two-part miniseries directed by Tommy Lee Wallace, and into a 2017 film and its 2019 sequel directed by Andy Muschietti.
', 'https://i.pinimg.com/originals/11/c1/8f/11c18fbb50b3abe089e5f519cc1988cb.png', 'It', 1986, 0, 7, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (9, null, 'The Shining is a horror novel by American author Stephen King. Published in 1977, it is King''s third published novel and first hardback bestseller: the success of the book firmly established King as a preeminent author in the horror genre. The setting and characters are influenced by King''s personal experiences, including both his visit to The Stanley Hotel in 1974 and his recovery from alcoholism. The novel was followed by a sequel, Doctor Sleep, published in 2013.

The Shining centers on the life of Jack Torrance, an aspiring writer and recovering alcoholic who accepts a position as the off-season caretaker of the historic Overlook Hotel in the Colorado Rockies. His family accompanies him on this job, including his young son Danny Torrance, who possesses "the shining", an array of psychic abilities that allow Danny to see the hotel''s horrific past. Soon, after a winter storm leaves them snowbound, the supernatural forces inhabiting the hotel influence Jack''s sanity, leaving his wife and son in incredible danger.

The novel was adapted into a 1980 feature film of the same name directed by Stanley Kubrick and co-written with Diane Johnson. Although King himself remains disappointed with the adaptation, having criticized its handling of the book''s themes and of Wendy''s character, it is regarded as one of the greatest horror films ever made. A television mini-series later premiered in 1997, withthe making closely monitored by King to ensure it had followed the novel''s narrative. King wrote the series himself and was reportedly unable to criticize the Kubrick version due to his contract.
', 'http://assets-cdn.shortlist.com/app/uploads/2012/06/24225210/30-most-evil-lines-from-books-3.jpg', 'The Shining', 1977, 0, 7, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (10, null, null, 'https://s-media-cache-ak0.pinimg.com/originals/ac/f9/56/acf95607f3684997f9ef1f4fac7d3326.jpg', 'Icewind Dale', 1988, 0, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (13, null, null, 'https://vignette.wikia.nocookie.net/forgottenrealms/images/b/be/Sea_of_Swords.jpg/revision/latest?cb=20070219001247', 'Sea of Swords', 2001, 0, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (14, null, null, 'https://upload.wikimedia.org/wikipedia/en/5/55/The-Dream-Quest-of-Unknown-Kadath.jpg', 'The Dream-Quest of Unknown Kadath', 1943, 0, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (16, null, null, 'https://i.pinimg.com/originals/1e/6f/6f/1e6f6fdedbdd9ab1ed3dc1a107a1b87e.jpg', 'Dune', 1963, 0, 17, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (19, null, null, 'https://s-media-cache-ak0.pinimg.com/originals/6f/cf/76/6fcf76874ffe4ba02a7c23fac931d17c.jpg', '1984', 1949, 0, 17, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (21, null, null, 'https://vignette.wikia.nocookie.net/hitchhikers/images/1/11/The_Hitchhiker%27s_Guide_to_the_Galaxy.jpg/revision/latest?cb=20140520174710', 'The Hitchhiker''s Guide to the Galaxy', 1979, 0, 22, null);

INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (6, 8);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (9, 8);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (10, 12);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (13, 12);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (14, 15);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (16, 18);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (19, 20);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (21, 23);

