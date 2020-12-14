package com.huyhuynh.recycleviewandretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    public void setDataBook(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);

        if (book==null){
            return;
        }
        //gán
        holder.txtBookName.setText(book.getNameBook());
        holder.imgBook.setImageResource(book.getResourceImgBook());
    }

    @Override
    public int getItemCount() {
        if (bookList!=null){
            return bookList.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        TextView txtBookName;
        ImageView imgBook;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBookName = itemView.findViewById(R.id.txtNameBook);
            imgBook = itemView.findViewById(R.id.imgBook);
        }
    }
}
