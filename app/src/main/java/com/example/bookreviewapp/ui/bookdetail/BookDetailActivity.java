//package com.example.bookreviewapp.ui.bookdetail;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.bookreviewapp.model.Book;
//
//public class BookDetailActivity extends AppCompatActivity {
//
//    private TextView titleTextView, authorTextView, descriptionTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_detail);
//
//        titleTextView = findViewById(R.id.titleTextView);
//        authorTextView = findViewById(R.id.authorTextView);
//        descriptionTextView = findViewById(R.id.descriptionTextView);
//
//        // Get the book object from the intent
//        Intent intent = getIntent();
//        Book book = (Book) intent.getSerializableExtra("book");
//
//        if (book != null) {
//            titleTextView.setText(book.getTitle());
//            authorTextView.setText(book.getAuthor());
//            descriptionTextView.setText(book.getDescription());
//        }
//    }
//}

package com.example.bookreviewapp.ui.bookdetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bookreviewapp.R;
import com.example.bookreviewapp.model.Book;

public class BookDetailActivity extends AppCompatActivity {

    private ImageView bookImage;
    private TextView bookTitle, bookAuthor, bookDescription;
    private RatingBar bookRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookImage = findViewById(R.id.bookImage);
        bookTitle = findViewById(R.id.bookTitle);
        bookAuthor = findViewById(R.id.bookAuthor);
        bookDescription = findViewById(R.id.bookDescription);
        bookRating = findViewById(R.id.bookRating);

        Book book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            bookTitle.setText(book.getTitle());
            bookAuthor.setText(book.getAuthor());
            bookDescription.setText(book.getDescription());
            bookRating.setRating(book.getRating());

            if (book.getImageUrl() != null && !book.getImageUrl().isEmpty()) {
                Glide.with(this).load(book.getImageUrl()).into(bookImage);
            } else {
                bookImage.setImageResource(R.mipmap.ic_launcher);
            }
        }
       else if (book == null) {
            Log.e("BookDetailActivity", "Received book is null. Check if Book is Serializable.");
            finish();  // Prevent crash
            return;
        }

    }
}
