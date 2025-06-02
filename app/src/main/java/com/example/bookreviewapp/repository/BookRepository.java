package com.example.bookreviewapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.network.BookApiService;
import com.example.bookreviewapp.room.BookDao;
import com.example.bookreviewapp.room.BookEntity;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    private BookApiService apiService;
    private BookDao bookDao;

    public BookRepository(BookApiService apiService, BookDao bookDao) {
        this.apiService = apiService;
        this.bookDao = bookDao;
    }

    public LiveData<List<Book>> getBooks() {
        MutableLiveData<List<Book>> booksLiveData = new MutableLiveData<>();

        // Mocked Retrofit call; implement real call if available
        // apiService.getBooks().enqueue(new Callback<List<Book>>() { ... });
        // For now, simulate empty list
        booksLiveData.setValue(null);

        return booksLiveData;
    }

    public void saveFavorite(Book book) {
        BookEntity entity = new BookEntity();
        entity.id = book.getId();
        entity.title = book.getTitle();
        entity.author = book.getAuthor();
        entity.description = book.getDescription();
        entity.rating = book.getRating();

        Executors.newSingleThreadExecutor().execute(() -> bookDao.insertBook(entity));
    }

    public LiveData<List<BookEntity>> getFavoriteBooks() {
        return bookDao.getAllBooks();
    }
}
