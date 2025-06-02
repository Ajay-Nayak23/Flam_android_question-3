package com.example.bookreviewapp.network;

import com.example.bookreviewapp.model.Book;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApiService {
    @GET("books")
    Call<List<Book>> getBooks();
}
