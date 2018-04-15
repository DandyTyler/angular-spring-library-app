package com.akos.libraryapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","votes","content"})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
    })
    @JoinTable(name = "BOOK_AUTHOR_DETAIL",
            joinColumns = @JoinColumn(name = "BOOK_ID", foreignKey = @ForeignKey(name = "FK_BOOK")),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", foreignKey = @ForeignKey(name = "FK_AUTHOR")))
    @JsonIgnoreProperties("books")
    private Set<Author> authors = new HashSet<>();;

    @ManyToOne(cascade =  {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "GENRE_ID", foreignKey = @ForeignKey(name = "FK_GENRE"))
    @JsonIgnoreProperties("books")
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Vote> votes = new HashSet<>();

    @Column(name = "PUBLISH_YEAR")
    private Integer publishYear;

    @Column(name = "IMAGE_URL")
    private String imageURL;

    @Column(name = "CONTENT")
    @Lob
    private byte[] content;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "RATING")
    @NotNull
    private Double rating = 0.0;


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

    public Double  getRating() {
        return rating;
    }

    public void setRating(Double  rating) {
        this.rating = rating;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
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