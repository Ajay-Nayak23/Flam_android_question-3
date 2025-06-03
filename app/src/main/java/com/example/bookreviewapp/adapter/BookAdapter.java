package com.example.bookreviewapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookreviewapp.R;
import com.example.bookreviewapp.model.Book;
import com.example.bookreviewapp.ui.bookdetail.BookDetailActivity;  // Correct path to BookDetailActivity

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    private Context context;
    private List<Book> books;
    private OnItemClickListener listener;

    public BookAdapter(Context context, List<Book> books, OnItemClickListener listener) {
        this.context = context;
        this.books = books != null ? books : new ArrayList<>();
        this.listener = listener;
    }

    public void setBooks(List<Book> newBooks) {
        this.books = newBooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);

        // Bind data to views
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.description.setText(book.getDescription());

        // Load the image using Glide
        if (book.getImageUrl() != null && !book.getImageUrl().isEmpty()) {
            Glide.with(context).load(book.getImageUrl()).into(holder.thumbnail);
        } else {
            holder.thumbnail.setImageResource(R.mipmap.ic_launcher);
        }

        // Set rating
        holder.rating.setRating(book.getRating());

        // Handle item click (optional)
        holder.itemView.setOnClickListener(v -> listener.onItemClick(book));

        // View Details button - pass the book data to BookDetailActivity
        holder.viewDetailsButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("book", book);  // Make sure Book implements Parcelable or Serializable
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView title, author, description;
        public ImageView thumbnail;
        public RatingBar rating;
        public Button viewDetailsButton;  // Button to view details

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize all views
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            rating = itemView.findViewById(R.id.rating);

            // Initialize the viewDetailsButton
            viewDetailsButton = itemView.findViewById(R.id.viewDetailsButton);  // Ensure this button is in your item layout
        }
    }
}
