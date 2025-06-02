package com.example.bookreviewapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.repository.BookRepository;
import com.example.bookreviewapp.room.BookDatabase;
import com.example.bookreviewapp.room.BookEntity;
import com.example.bookreviewapp.network.RetrofitClient;
import com.example.bookreviewapp.network.BookApiService;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private BookRepository repository;
    private LiveData<List<Book>> bookList;
    private LiveData<List<BookEntity>> favorites;

    public BookViewModel(@NonNull Application application) {
        super(application);

        BookApiService apiService = RetrofitClient.getService();
        repository = new BookRepository(apiService, BookDatabase.getInstance(application).bookDao());

        bookList = repository.getBooks();
        favorites = repository.getFavoriteBooks();
    }

    public LiveData<List<Book>> getBooks() {
        return bookList;
    }

    public LiveData<List<BookEntity>> getFavorites() {
        return favorites;
    }

    public void saveFavorite(Book book) {
        repository.saveFavorite(book);
    }
}
