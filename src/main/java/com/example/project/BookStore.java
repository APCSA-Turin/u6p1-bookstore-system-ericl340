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

    public void setUsers(User[] u){//setter
        users = u;
    }

    public Book[] getBooks(){//getter
        return books;
    }

    public void addUser(User user){
        for (int i = 0; i < users.length; i++) {//iterates through the list of users and replaces the first empty slot
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
            }//finds specified user and sets them to null
        }
        consolidateUsers();
    }

    public void consolidateUsers(){
        User[] n = users;
        users = new User[n.length];
        int i = 0;
        for (User u: n) {//takes all the users and sets them to the front of the list
            if (u != null) {
                users[i] = u;
                i++;
            }
        }
    }
    public void consolidateBooks(){
        int l = 0;
        for (Book b: books) {//finds number of books
            if (b != null) {
                l++;
            }
        }
        Book[] n = books;
        books = new Book[l];//array with length of num of books
        int i = 0;
        for (Book b: n) {//moves them all to front
            if (b != null) {
                books[i] = b;
                i++;
            }
        }
    }
    public void addBook(Book book){
        Book[] p = books;
        books = new Book[books.length + 1];
        for (int i = 0; i < p.length; i++) {//reassigns all the books to new array longer by 1, last slot goes to new book
            books[i] = p[i];
        }
        books[p.length] = book;
    }

    public void insertBook(Book book, int index){
        Book[] c = books;
        books = new Book[0];
        for (int i = 0; i < c.length; i++) {//readds all the books, with the new book at specified index
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
        for (int i = 0; i < books.length; i++) {//loops through books and finds matching books
            if (books[i].getIsbn().equals(isbn) && books[i].getTitle().equals(t) && books[i].getAuthor().equals(a) && books[i].getYearPublished() == y) {
                q = books[i].getQuantity();
                if (q > 1) {//if it has more than 1, it decreases the quantity
                    books[i].setQuantity(q - 1);
                }else{//if it ends up as 0 itll get removed
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