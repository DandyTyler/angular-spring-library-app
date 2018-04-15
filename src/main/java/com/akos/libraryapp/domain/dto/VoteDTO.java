package com.akos.libraryapp.domain.dto;

import com.akos.libraryapp.domain.entity.Vote;

import java.io.Serializable;

public class VoteDTO implements Serializable{

    private String username;

    private Long bookId;

    private String bookName;

    private Long value;

    private String comment;

    public VoteDTO() {
    }

    public VoteDTO(String username, Long bookId, String bookName, Long value, String comment) {
        this.username = username;
        this.bookId = bookId;
        this.bookName = bookName;
        this.value = value;
        this.comment = comment;
    }

    public VoteDTO(Vote vote) {

        this.username = vote.getUsername();

        this.bookId = vote.getBookId();

        this.bookName= vote.getBook().getName();

        this.value = vote.getValue();

        this.comment = vote.getComment();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
