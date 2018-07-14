package com.akos.libraryapp.repositories;

import com.akos.libraryapp.domain.entity.BookOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {

    Page<BookOrder> getAllBy(Pageable pageable);

    List<BookOrder> getAllByUsername(String username);

    Page<BookOrder> getAllByUsername(String username, Pageable pageable);
}
