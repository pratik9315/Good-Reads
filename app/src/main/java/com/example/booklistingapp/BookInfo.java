package com.example.booklistingapp;

public class BookInfo {
    private String bookTitle;
    private String bookSubTitle;
    private String bookAuthor;
    private String rating;

    public BookInfo(String bookTitle, String bookSubTitle, String bookAuthor, String rating) {
        this.bookTitle = bookTitle;
        this.bookSubTitle = bookSubTitle;
        this.bookAuthor = bookAuthor;
        this.rating = rating;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookSubTitle() {
        return bookSubTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getRating() {
        return rating;
    }
}
