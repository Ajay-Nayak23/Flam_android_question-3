package com.example.bookreviewapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookreviewapp.adapter.BookAdapter;
import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.repository.BookRepository;
import com.example.bookreviewapp.room.BookDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private BookRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize BookRepository
        repository = new BookRepository(
                com.example.bookreviewapp.network.RetrofitClient.getService(),
                BookDatabase.getInstance(this).bookDao()
        );

        // Load books
        repository.getBooks().observe(this, books -> {
            adapter = new BookAdapter(this, books, book -> {
                // handle click if needed
            });
            recyclerView.setAdapter(adapter);
        });
    }
}
