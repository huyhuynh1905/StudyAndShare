package com.huyhuynh.recycleviewandretrofit;

import java.util.List;

public class Categry {
    private String nameCategry;
    private List<Book> bookList;

    public Categry(String nameCategry, List<Book> bookList) {
        this.nameCategry = nameCategry;
        this.bookList = bookList;
    }

    public String getNameCategry() {
        return nameCategry;
    }

    public void setNameCategry(String nameCategry) {
        this.nameCategry = nameCategry;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
