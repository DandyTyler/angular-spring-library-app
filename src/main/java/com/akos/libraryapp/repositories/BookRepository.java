package com.akos.libraryapp.repositories;

import com.akos.libraryapp.domain.entity.Author;
import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByName(String name);

    List <Book> findAllByAuthors (Author authors);

    Book findByName(String name);

    List<Book> findAllByGenre (Genre genre);

    List<Book> findAllByNameStartsWith (String str);

    Page<Book> findAllByGenre_Id(Long genreId, Pageable pageable);

    Page<Book> findAllByNameIgnoreCaseContains(String name, Pageable pageable);

    Page<Book> findAllByNameIgnoreCaseContainsAndGenre_Id(String name, Long genreId, Pageable pageable);

}
