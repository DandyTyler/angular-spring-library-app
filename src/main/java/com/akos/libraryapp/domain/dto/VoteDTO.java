package com.akos.libraryapp.domain.dto;

import com.akos.libraryapp.domain.entity.Vote;

import java.io.Serializable;

public class VoteDTO implements Serializable{

    private String username;

    private Long bookId;

    private String bookName;

    private Long value;

    public VoteDTO() {
    }

    public VoteDTO(String username, Long bookId, String bookName, Long value) {
        this.username = username;
        this.bookId = bookId;
        this.bookName = bookName;
        this.value = value;
    }

    public VoteDTO(Vote vote) {

        this.username = vote.getUsername();

        this.bookId = vote.getBookId();

        this.bookName= vote.getBook().getName();

        this.value = vote.getValue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
