package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];
    //requires 1 empty constructor
    public BookStore() {}
    public User[] getUsers(){
        return users;
    }

    public void setUsers(User[] u){
        users = u;
    }

    public Book[] getBooks(){
        return books;
    }

    public void addUser(User user){
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }

    public void removeUser(User user){
        String uid = user.getId();
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId().equals(uid)) {
                users[i] = null;
                break;
            }
        }
        consolidateUsers();
    }

    public void consolidateUsers(){
        User[] n = users;
        users = new User[n.length];
        int i = 0;
        for (User u: n) {
            if (u != null) {
                users[i] = u;
                i++;
            }
        }
    }
    public void consolidateBooks(){
        int l = 0;
        for (Book b: books) {
            if (b != null) {
                l++;
            }
        }
        Book[] n = books;
        books = new Book[l];
        int i = 0;
        for (Book b: n) {
            if (b != null) {
                books[i] = b;
                i++;
            }
        }
    }
    public void addBook(Book book){
        Book[] p = books;
        books = new Book[books.length + 1];
        for (int i = 0; i < p.length; i++) {
            books[i] = p[i];
        }
        books[p.length] = book;
    }

    public void insertBook(Book book, int index){
        Book[] c = books;
        books = new Book[0];
        for (int i = 0; i < c.length; i++) {
            if (i == index) {
                addBook(book);
            }
            addBook(c[i]);
        }
        if (index == c.length) {
            addBook(book);
        }
    }

    public void removeBook(Book book){
        String isbn = book.getIsbn();
        String t = book.getTitle();
        String a = book.getAuthor();
        int y = book.getYearPublished();
        int q;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(isbn) && books[i].getTitle().equals(t) && books[i].getAuthor().equals(a) && books[i].getYearPublished() == y) {
                q = books[i].getQuantity();
                if (q > 1) {
                    books[i].setQuantity(q - 1);
                }else{
                    books[i] = null;
                    consolidateBooks();
                }
                break;
            }
        }
    }
       
    public String bookStoreBookInfo(){
        String res = "Books:\n";
        for (int i = 0; i < books.length; i++) {
            res += books[i].bookInfo() + "\n";
        }
        return res;
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){
        String res = "Users:\n";
        for (User u : users) {
            if (u != null) {
                res += u.userInfo() + "\n";
            }
        }
        return res;
    } //you are not tested on this method but use it for debugging purposes
}