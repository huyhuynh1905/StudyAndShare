package com.huyhuynh.recycleviewandretrofit;

public class Book {
    private String nameBook;
    private int resourceImgBook;

    public Book(String nameBook, int resourceImgBook) {
        this.nameBook = nameBook;
        this.resourceImgBook = resourceImgBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getResourceImgBook() {
        return resourceImgBook;
    }

    public void setResourceImgBook(int resourceImgBook) {
        this.resourceImgBook = resourceImgBook;
    }
}
