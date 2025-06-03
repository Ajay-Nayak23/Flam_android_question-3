package com.example.bookreviewapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookreviewapp.adapter.BookAdapter;
import com.example.bookreviewapp.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy book list for testing
//        List<Book> dummyBooks = new ArrayList<>();
//        dummyBooks.add(new Book("1984", "George Orwell", "Dystopian novel", 4.5f, ""));
//        dummyBooks.add(new Book("To Kill a Mockingbird", "Harper Lee", "Classic novel", 4.8f, ""));
//        dummyBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "American classic", 4.2f, ""));
        List<Book> dummyBooks = List.of(
                new Book(
                        "1984",
                        "George Orwell",
                        "A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.",
                        4.5f,
                        "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327144697i/3744438.jpg"
                ),
                new Book(
                        "To Kill a Mockingbird",
                        "Harper Lee",
                        "A novel of warmth and humor despite dealing with serious issues of rape and racial inequality.",
                        4.8f,
                        "https://i0.wp.com/www.lukeharkness.com/wp-content/uploads/2021/09/To-Kill-A-Mockingbird-PINTEREST.png?resize=400%2C600&ssl=1"
                ),
                new Book(
                        "The Great Gatsby",
                        "F. Scott Fitzgerald",
                        "A story of the mysteriously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.",
                        4.2f,
                        "https://d28hgpri8am2if.cloudfront.net/book_images/onix/cvr9781645176596/the-great-gatsby-and-other-works-9781645176596_hr.jpg"
                ),
                new Book(
                        "Pride and Prejudice",
                        "Jane Austen",
                        "A romantic novel that critiques the British landed gentry at the end of the 18th century.",
                        4.7f,
                        "https://rukminim3.flixcart.com/image/850/1000/kkec4280/book/d/h/d/pride-prejudice-original-imafzra6pfewjjwb.jpeg?q=90&crop=false"
                ),
                new Book(
                        "The Catcher in the Rye",
                        "J.D. Salinger",
                        "A novel about teenage rebellion and angst as told by the iconoclastic Holden Caulfield.",
                        4.0f,
                        "https://savethecat.com/wp-content/uploads/2019/05/243a0ba33adbee20d3ed689fbf712ec8-jd-salinger-holden-caulfield.jpg"
                ),
                new Book(
                        "The Alchemist",
                        "Paulo Coelho",
                        "A philosophical story about a young shepherd's journey to realize his dream.",
                        4.6f,
                        "https://m.media-amazon.com/images/I/61HAE8zahLL.jpg"
                ),
                new Book(
                        "Sapiens: A Brief History of Humankind",
                        "Yuval Noah Harari",
                        "A thought-provoking journey through the history of human evolution and civilization.",
                        4.9f,
                        "data:image/png;base64,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"
                )
        );

        // Set adapter
        adapter = new BookAdapter(this, dummyBooks, book -> {
            // Optional: handle item click if needed
            // Toast.makeText(this, "Clicked: " + book.getTitle(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);
    }
}
