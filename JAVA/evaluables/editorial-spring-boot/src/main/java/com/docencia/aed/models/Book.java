package com.docencia.aed.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "publication_year", nullable = true)
    int publicationYear;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    /**
     * Construcor vacio
     */
    public Book() {
    }

    /**
     * Constructor con id
     * 
     * @param id id del libro
     */
    public Book(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param id              id del libro
     * @param title           titulo del libro
     * @param publicationYear año de publicacion del libro
     * @param author          id del autor del libro
     */
    public Book(Long id, String title, int publicationYear, Author author) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return id == other.id;
    }

}
