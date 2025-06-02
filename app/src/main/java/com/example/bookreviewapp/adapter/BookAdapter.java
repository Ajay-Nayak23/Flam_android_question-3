package com.example.bookreviewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bookreviewapp.R;
import com.example.bookreviewapp.model.Book;

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

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(book));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView title, author;

        public BookViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            author = itemView.findViewById(R.id.textAuthor);
        }
    }
}
