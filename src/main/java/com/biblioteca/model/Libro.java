package com.biblioteca.model;


// Clase que define los datos de un libro
public class Libro {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String category;
    private boolean available;

    public Libro() {}

    public Libro(Long id, String title, String author, String isbn,
                 int publicationYear, String category, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}