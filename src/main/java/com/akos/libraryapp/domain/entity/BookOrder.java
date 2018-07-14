package com.akos.libraryapp.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK_ORDER")
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "IS_ACCEPTED")
    private Boolean isAccepted;

    @Column(name = "IS_RETURNED")
    private Boolean returned;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public BookOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public Boolean getReturned() {
        return returned;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

