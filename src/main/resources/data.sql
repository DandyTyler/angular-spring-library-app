INSERT INTO PUBLIC.USER (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (1, 'admin@admin.com', true, 'admin', 'admin', '2018-04-03 01:40:22.321000000', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin');
INSERT INTO PUBLIC.USER (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (4, 'enabled@user.com', true, 'user', 'user', '2018-04-03 01:40:22.321000000', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user');
INSERT INTO PUBLIC.USER (ID, EMAIL, ENABLED, FIRSTNAME, LASTNAME, LASTPASSWORDRESETDATE, PASSWORD, USERNAME) VALUES (5, 'disabled@user.com', false, 'user', 'user', '2018-04-03 01:40:22.321000000', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'disabled');

INSERT INTO PUBLIC.AUTHORITY (ID, NAME) VALUES (2, 'ROLE_USER');
INSERT INTO PUBLIC.AUTHORITY (ID, NAME) VALUES (3, 'ROLE_ADMIN');

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
', '1947-09-21 01:40:22.586000000', 'Stephen King', 'https://pbs.twimg.com/profile_images/378800000836981162/b683f7509ec792c3e481ead332940cdc.jpeg');
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (12, null, '1947-09-21 01:40:22.586000000', 'R.A. Salvatore', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (15, null, '1890-03-20 01:40:22.586000000', 'H.P. Lovecraft ', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (18, null, '1986-10-08 01:40:22.586000000', 'Frank Herbert', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (20, null, '1903-06-25 01:40:22.586000000', 'George Orwell', null);
INSERT INTO PUBLIC.AUTHOR (ID, BIOGRAPHY, BIRTHDAY, FULL_NAME, PHOTO_URL) VALUES (23, null, '1952-03-11 01:40:22.586000000', 'Douglas Adams', null);

INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (6, null, 'Description', 'https://i.pinimg.com/originals/11/c1/8f/11c18fbb50b3abe089e5f519cc1988cb.png', 'It', 1986, null, 7, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (9, null, null, 'http://assets-cdn.shortlist.com/app/uploads/2012/06/24225210/30-most-evil-lines-from-books-3.jpg', 'The Shining', 1977, null, 7, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (10, null, null, 'https://s-media-cache-ak0.pinimg.com/originals/ac/f9/56/acf95607f3684997f9ef1f4fac7d3326.jpg', 'Icewind Dale', 1988, null, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (13, null, null, 'https://vignette.wikia.nocookie.net/forgottenrealms/images/b/be/Sea_of_Swords.jpg/revision/latest?cb=20070219001247', 'Sea of Swords', 2001, null, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (14, null, null, 'https://upload.wikimedia.org/wikipedia/en/5/55/The-Dream-Quest-of-Unknown-Kadath.jpg', 'The Dream-Quest of Unknown Kadath', 1943, null, 11, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (16, null, null, 'https://i.pinimg.com/originals/1e/6f/6f/1e6f6fdedbdd9ab1ed3dc1a107a1b87e.jpg', 'Dune', 1963, null, 17, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (19, null, null, 'https://s-media-cache-ak0.pinimg.com/originals/6f/cf/76/6fcf76874ffe4ba02a7c23fac931d17c.jpg', '1984', 1949, null, 17, null);
INSERT INTO PUBLIC.BOOK (ID, CONTENT, DESCRIPTION, IMAGE_URL, NAME, PUBLISH_YEAR, RATING, GENRE_ID, PUBLISHER_ID) VALUES (21, null, null, 'https://vignette.wikia.nocookie.net/hitchhikers/images/1/11/The_Hitchhiker%27s_Guide_to_the_Galaxy.jpg/revision/latest?cb=20140520174710', 'The Hitchhiker''s Guide to the Galaxy', 1979, null, 22, null);

INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (6, 8);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (9, 8);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (10, 12);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (13, 12);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (14, 15);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (16, 18);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (19, 20);
INSERT INTO PUBLIC.BOOK_AUTHOR_DETAIL (BOOK_ID, AUTHOR_ID) VALUES (21, 23);

