package com.akos.libraryapp.services;

import com.akos.libraryapp.domain.entity.Book;
import com.akos.libraryapp.domain.entity.Vote;
import com.akos.libraryapp.repositories.BookRepository;
import com.akos.libraryapp.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VoteService {

    private BookService bookService;

    private VoteRepository voteRepository;

    @Autowired
    public VoteService(BookService bookService, VoteRepository voteRepository) {
        this.bookService = bookService;
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote) {

        Vote oldVote = voteRepository.getByUsernameAndBookId(vote.getUsername(), vote.getBookId());
        if (oldVote != null)
            return oldVote;

        voteRepository.save(vote);
        voteRepository.findAllByBookId(vote.getBookId()).size();

        Book book = bookService.getById(vote.getBookId());

        Long newRating = 0L;

        for (Vote v : voteRepository.findAllByBookId(book.getId())) {
            newRating += v.getValue();
        }

        int voteCount = voteRepository.findAllByBookId(book.getId()).size();
        if (voteCount > 0)
            newRating = newRating / voteCount;

        book.setRating(newRating);
        bookService.save(book);

        return vote;
    }

    public List<Vote> getUserVotes(String username) {

        return voteRepository.findAllByUsername(username);
    }

    public List<Vote> getBookVotes(String username) {
        return voteRepository.findAllByUsername(username);
    }

    public Vote getByUsernameAndBookId(String username, Long bookId) {
        Vote vote = voteRepository.getByUsernameAndBookId(username, bookId);
        if (vote != null)
            return vote;

        vote = new Vote();
        vote.setUsername("null");
        vote.setValue(0L);
        return vote;
    }
}
