package com.huyhuynh.recycleviewandretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategryAdapter extends RecyclerView.Adapter<CategryAdapter.CategryViewholder> {

    private Context context;
    private List<Categry> categryList;

    public CategryAdapter(Context context) {
        this.context = context;
    }

    public void setCategryList(List<Categry> categryList) {
        this.categryList = categryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categry,parent,false);
        return new CategryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategryViewholder holder, int position) {
        Categry categry = categryList.get(position);
        if (categry==null){
            return;
        }

        holder.txtNameCategry.setText(categry.getNameCategry());

        //Xử lí RecycleView của Book lồng trong này:
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerViewBook.setLayoutManager(layoutManager);

        BookAdapter bookAdapter = new BookAdapter();
        bookAdapter.setDataBook(categry.getBookList());
        holder.recyclerViewBook.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if (categryList!=null){
            return categryList.size();
        }
        return 0;
    }

    public class CategryViewholder extends RecyclerView.ViewHolder{

        private TextView txtNameCategry;
        private RecyclerView recyclerViewBook;

        public CategryViewholder(@NonNull View itemView) {
            super(itemView);
            txtNameCategry = itemView.findViewById(R.id.txtNameCategry);
            recyclerViewBook = itemView.findViewById(R.id.recycleViewCategry);
        }
    }
}
