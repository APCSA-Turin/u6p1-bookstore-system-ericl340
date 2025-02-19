package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[] books = new Book[5];
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String n, String id) {
        name = n;
        Id = id;
    }
    public String getName() {//getter
        return name;
    }

    public void setName(String n) {//setter
        name = n;
    }

    public String getId() {//getter
        return Id;
    }

    public void setId(String id) {//setter
        Id = id;
    }

    public Book[] getBooks() {//getter
        return books;
    }

    public void setBooks(Book[] b) {//setter
        books = b;
    }

    public String bookListInfo(){
        String res = "";
        for (Book book: books) {
            if (book == null)
                res += "empty\n";
            else
                res += book.bookInfo() + "\n";
        }
        return res;
    } //returns a booklist for the user, if empty, output "empty"

    public String userInfo(){
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    } //returns  "Name: []\nID: []\nBooks:\n[]"
}