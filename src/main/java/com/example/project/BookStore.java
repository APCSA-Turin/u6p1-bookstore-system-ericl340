package com.example.project;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[5];
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
        User[] nUsers = new User[users.length];
        int i = 0;
        for (User u: users) {
            if (u != null) {
                nUsers[i] = u;
                i++;
            }
        }
        users = nUsers;
    }
    public void consolidateBooks(){
        Book[] nBooks = new Book[books.length];
        int i = 0;
        for (Book b: books) {
            if (b != null) {
                nBooks[i] = b;
                i++;
            }
        }
        books = nBooks;
    }
    public void addBook(Book book){
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    public void insertBook(Book book, int index){
        Book[] copy = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            copy[i] = books[i];
        }
        books = new Book[books.length];
        books[index] = book;
        addBook(book);
    }

    public void removeBook(Book book){
        String isbn = book.getIsbn();
        for (int i = 0; i < users.length; i++) {
            if (books[i] != null && books[i].getIsbn().equals(isbn)) {
                books[i] = null;
                break;
            }
        }
        consolidateBooks();
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
        for (int i = 0; i < users.length; i++) {
            res += users[i].userInfo() + "\n";
        }
        return res;
    } //you are not tested on this method but use it for debugging purposes
    public static void main(String[] args) {
                BookStore store = new BookStore(); 
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        Book[] expected = {b1,b2,b3,b4,b5};
        System.out.println(store.bookStoreBookInfo());
    }

}