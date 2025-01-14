package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book(String t, String a, int y, String i, int q) {
        title = t;
        author = a;
        yearPublished = y;
        isbn = i;
        quantity = q;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int y) {
        yearPublished = y;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String i) {
        isbn = i;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public String bookInfo(){
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    } //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
       
}