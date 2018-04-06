package com.akos.libraryapp.repositories;

import com.akos.libraryapp.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository <Vote, Long> {

    List<Vote> findAllByUsername(String username);

    List<Vote> findAllByBookId (Long bookId);

    Vote getByUsernameAndBookId(String username, long bookId);
}
