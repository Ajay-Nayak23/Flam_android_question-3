package com.example.bookreviewapp.ui.booklist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.bookreviewapp.R;
import com.example.bookreviewapp.adapter.BookAdapter;
import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.ui.bookdetail.BookDetailActivity;
import com.example.bookreviewapp.viewmodel.BookViewModel;

public class BookListActivity extends AppCompatActivity {
    private BookViewModel viewModel;
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BookAdapter(this, new ArrayList<>(), book -> {
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra("book", book);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(BookViewModel.class);
        viewModel.getBooks().observe(this, books -> adapter.setBooks(books));
    }
}
