package com.akos.libraryapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_AUTHOR_DETAIL",
            joinColumns = @JoinColumn(name = "BOOK_ID", foreignKey = @ForeignKey(name = "FK_BOOK")),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_AUTHOR")))
    @JsonIgnoreProperties("books")
    private Set<Author> authors = new HashSet<>();;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GENRE_ID", foreignKey = @ForeignKey(name = "FK_GENRE"))
    @JsonIgnoreProperties("books")
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISHER_ID", foreignKey = @ForeignKey(name = "FK_PUBLISHER"))
    private Publisher publisher;

    @Column(name = "PUBLISH_YEAR")
    private Integer publishYear;

    @Column(name = "IMAGE_URL")
    private String imageURL;
    @Lob
    private byte[] content;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RATING")
    private String rating;


    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ",Authors='" + authors + '\'' +
                '}';
    }
}