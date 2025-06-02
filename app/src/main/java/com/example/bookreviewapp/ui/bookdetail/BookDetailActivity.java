package com.example.bookreviewapp.ui.bookdetail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookreviewapp.R;
import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.viewmodel.BookViewModel;

public class BookDetailActivity extends AppCompatActivity {
    private BookViewModel viewModel;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        book = (Book) getIntent().getSerializableExtra("book");

        TextView title = findViewById(R.id.title);
        TextView desc = findViewById(R.id.description);

        title.setText(book.getTitle());
        desc.setText(book.getDescription());

        Button favBtn = findViewById(R.id.save_button);
        viewModel = new ViewModelProvider(this).get(BookViewModel.class);

        favBtn.setOnClickListener(v -> {
            viewModel.saveFavorite(book);
            Toast.makeText(this, "Saved to favorites", Toast.LENGTH_SHORT).show();
        });
    }
}
