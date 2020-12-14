package com.huyhuynh.recycleviewandretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private CategryAdapter categryAdapter;
    private MultiUserAdapter multiUserAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();

        //Thêm data
        //userAdapter.setData(getListUser());
        //categryAdapter.setCategryList(getListCatagry());
        multiUserAdapter.setMultiUsers(getListMultiUser());
        //set adapver
        recyclerView.setAdapter(multiUserAdapter);

    }

    private void init() {
        recyclerView = findViewById(R.id.recycleView);
        userAdapter = new UserAdapter(this);
        categryAdapter = new CategryAdapter(this);
        multiUserAdapter = new MultiUserAdapter();

        //Tạo gridlayout để hiển thị loại grid
        //GridLayoutManager layoutManager = new GridLayoutManager(this,3); //spanCount là số cột
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<User> getListUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("Ảnh Số 1",R.drawable.avt1));
        users.add(new User("Ảnh Số 2",R.drawable.avt2));
        users.add(new User("Ảnh Số 3",R.drawable.avt3));
        users.add(new User("Ảnh Số 4",R.drawable.avt4));
        users.add(new User("Ảnh Số 5",R.drawable.avt1));
        users.add(new User("Ảnh Số 6",R.drawable.avt2));
        users.add(new User("Ảnh Số 7",R.drawable.avt3));
        users.add(new User("Ảnh Số 8",R.drawable.avt4));
        users.add(new User("Ảnh Số 9",R.drawable.avt1));
        users.add(new User("Ảnh Số 1",R.drawable.avt1));
        users.add(new User("Ảnh Số 2",R.drawable.avt2));
        users.add(new User("Ảnh Số 3",R.drawable.avt3));
        users.add(new User("Ảnh Số 4",R.drawable.avt4));
        users.add(new User("Ảnh Số 5",R.drawable.avt1));
        users.add(new User("Ảnh Số 6",R.drawable.avt2));
        users.add(new User("Ảnh Số 7",R.drawable.avt3));
        users.add(new User("Ảnh Số 8",R.drawable.avt4));
        users.add(new User("Ảnh Số 9",R.drawable.avt1));
        return users;
    }

    private List<User> getListUserForStagger(){
        List<User> users = new ArrayList<>();
        users.add(new User("Ảnh Số 1",R.drawable.logo));
        users.add(new User("Ảnh Số 2",R.drawable.logo2));
        users.add(new User("Ảnh Số 3",R.drawable.logo3));
        users.add(new User("Ảnh Số 4",R.drawable.avt4));
        users.add(new User("Ảnh Số 5",R.drawable.logo2));
        users.add(new User("Ảnh Số 6",R.drawable.logo));
        users.add(new User("Ảnh Số 7",R.drawable.logo3));
        users.add(new User("Ảnh Số 8",R.drawable.avt1));
        users.add(new User("Ảnh Số 9",R.drawable.logo3));
        users.add(new User("Ảnh Số 1",R.drawable.logo3));
        users.add(new User("Ảnh Số 2",R.drawable.logo));
        users.add(new User("Ảnh Số 3",R.drawable.logo));
        users.add(new User("Ảnh Số 4",R.drawable.logo2));
        users.add(new User("Ảnh Số 5",R.drawable.logo2));
        users.add(new User("Ảnh Số 6",R.drawable.avt2));
        users.add(new User("Ảnh Số 7",R.drawable.avt3));
        users.add(new User("Ảnh Số 8",R.drawable.avt4));
        users.add(new User("Ảnh Số 9",R.drawable.avt1));
        return users;
    }

    private List<Categry> getListCatagry(){
        List<Categry> categryList = new ArrayList<>();
        categryList.add(new Categry("Categry 1",getListBook()));
        categryList.add(new Categry("Categry 2",getListBook()));
        categryList.add(new Categry("Categry 3",getListBook()));
        categryList.add(new Categry("Categry 4",getListBook()));
        categryList.add(new Categry("Categry 5",getListBook()));
        return categryList;
    }

    private List<Book> getListBook(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Ảnh Số 1",R.drawable.avt1));
        books.add(new Book("Ảnh Số 2",R.drawable.avt2));
        books.add(new Book("Ảnh Số 3",R.drawable.avt3));
        books.add(new Book("Ảnh Số 4",R.drawable.avt4));
        books.add(new Book("Ảnh Số 5",R.drawable.avt1));
        books.add(new Book("Ảnh Số 6",R.drawable.avt2));
        books.add(new Book("Ảnh Số 7",R.drawable.avt3));
        books.add(new Book("Ảnh Số 8",R.drawable.avt4));
        books.add(new Book("Ảnh Số 9",R.drawable.avt1));
        books.add(new Book("Ảnh Số 3",R.drawable.avt3));
        books.add(new Book("Ảnh Số 4",R.drawable.avt4));
        books.add(new Book("Ảnh Số 5",R.drawable.avt1));
        books.add(new Book("Ảnh Số 6",R.drawable.avt2));
        books.add(new Book("Ảnh Số 7",R.drawable.avt3));
        books.add(new Book("Ảnh Số 8",R.drawable.avt4));
        books.add(new Book("Ảnh Số 9",R.drawable.avt1));
        return books;
    }

    private List<MultiUser> getListMultiUser(){
        List<MultiUser> users = new ArrayList<>();
        users.add(new MultiUser("Ảnh Số 1",R.drawable.avt1,true));
        users.add(new MultiUser("Ảnh Số 2",R.drawable.avt2,true));
        users.add(new MultiUser("Ảnh Số 3",R.drawable.avt3, true));
        users.add(new MultiUser("Ảnh Số 4",R.drawable.avt4, true));
        users.add(new MultiUser("Ảnh Số 5",R.drawable.avt1, false));
        users.add(new MultiUser("Ảnh Số 6",R.drawable.avt2,false));
        users.add(new MultiUser("Ảnh Số 7",R.drawable.avt3,false));
        users.add(new MultiUser("Ảnh Số 8",R.drawable.avt4,false));
        users.add(new MultiUser("Ảnh Số 9",R.drawable.avt1,false));
        users.add(new MultiUser("Ảnh Số 1",R.drawable.avt1,false));
        users.add(new MultiUser("Ảnh Số 9",R.drawable.avt1,true));
        return users;
    }
}