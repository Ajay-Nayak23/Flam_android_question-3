package com.example.bookreviewapp.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class BookEntity {
    @PrimaryKey
    @NonNull
    public String id;

    public String title;
    public String author;
    public String description;
    public float rating;

    // Empty constructor for Room
    public BookEntity() {}

    // Getters and setters (optional)
}
