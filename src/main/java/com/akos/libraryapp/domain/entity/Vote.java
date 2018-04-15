package com.akos.libraryapp.domain.entity;

import com.akos.libraryapp.domain.entity.security.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "VOTES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user", "book"})
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", referencedColumnName = "username", foreignKey = @ForeignKey(name = "FK_USER_USERNAME"), insertable=false, updatable=false)
    private User user;

    @Column(name = "USERNAME")
    @NotNull
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_BOOK_ID"), insertable=false, updatable=false)
    private Book book;

    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "VALUE")
    private Long value;

    @Column(name = "COMMENTARY", length = 140)
    private String comment;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "value=" + value +
                '}';
    }
}
