package com.example.bookreviewapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBook(BookEntity book);

    @Query("SELECT * FROM favorites")
    LiveData<List<BookEntity>> getAllBooks();
}
