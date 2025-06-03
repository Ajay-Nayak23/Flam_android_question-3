package com.example.bookreviewapp.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String description;
    private float rating;
    private String imageUrl;

    public Book(String title, String author, String description, float rating, String imageUrl) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
