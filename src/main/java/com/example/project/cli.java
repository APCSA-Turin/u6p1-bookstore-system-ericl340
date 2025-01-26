package com.example.project;
import java.util.Scanner;
public class cli{
    private BookStore bks = new BookStore();
    Scanner sc = new Scanner(System.in);
    public void run() {
        s: while (true) {
            System.out.println("Press 0 to exit application\nPress 1 to add new book\nPress 2 to increase quantity of a book\nPress 3 to search for a book\nPress 4 to show all books\nPress 5 to register student\nPress 6 to show all registered students\nPress 7 to check out book\nPress 8 to check in book");
            switch (sc.nextInt()) {
                case 0:
                    break s;
                case 1:
                    addBook();
                    break;
                case 2:
                    incrQty();
                    break;
                case 3:
                    searchBk();
                    cont();
                    break;
                case 4:
                    System.out.println(bks.bookStoreBookInfo());
                    cont();
                    break;
                case 5:
                    regStd();
                    break;
                case 6:
                    System.out.println(bks.bookStoreUserInfo());
                    cont();
                    break;
                case 7:
                    ckOut();
                    break;
                case 8:
                    ckIn();
                    break;
                default:
                    break;
            }
        }
    }
    public void addBook() {
        System.out.print("Enter book title: ");
        sc.nextLine();
        String t = sc.nextLine();
        System.out.print("Enter book author: ");
        String a = sc.nextLine();
        System.out.print("Enter publication date: ");
        int y = sc.nextInt();
        System.out.print("Enter book ISBN: ");
        sc.nextLine();
        String i = sc.nextLine();
        System.out.print("Enter quantity: ");
        int q = sc.nextInt();
        Book b = new Book(t, a, y, i, q);
        bks.addBook(b);
    }
    public void incrQty() {
        Book[] books = bks.getBooks();
        int i = 0;
        for (Book b : books) {
            if (b != null) {
                System.out.println(i + ". " + b.bookInfo());
                i++;
            }
        }
        System.out.print("Enter book number: ");
        i = 0;
        int sel = sc.nextInt();
        System.out.print("Enter quantity: ");
        int q = sc.nextInt();
        for (Book b : books) {
            if (b != null) {
                if (i == sel) {
                    b.setQuantity(q + b.getQuantity());
                    break;
                }
                i++;
            }
        }
    }
    public void searchBk() {
        System.out.print("Enter search term: ");
        sc.nextLine();
        String t = sc.nextLine();
        for (Book b : bks.getBooks()) {
            if (b.getTitle().indexOf(t) != -1) {
                System.out.println(b.bookInfo());
            }
        }
    }
    public void regStd() {
        if (bks.getUsers()[9] == null) {
            System.out.print("Enter user's name: ");
            sc.nextLine();
            String n = sc.nextLine();
            User u = new User(n, IdGenerate.getCurrentId());
            IdGenerate.generateID();
            bks.addUser(u);
        }else{
            System.out.println("Reached user limit");
            cont();
        }
    }
    public void ckOut() {
        User[] users = bks.getUsers();
        int uc = 0;
        for (User u : users) {
            if (u != null) {
                System.out.println(uc + ". " + u.getName());
                uc++;
            }
        }
        System.out.print("Enter user number: ");
        uc = 0;
        int selU = sc.nextInt();
        User user = new User(null, null);
        for (User u : users) {
            if (u != null) {
                if (uc == selU) {
                    user = u;
                    break;
                }
                uc++;
            }
        }
        boolean avail = false;
        Book[] userBooks = user.getBooks();
        for (Book b : userBooks) {
            if (b == null) {
                avail = true;
                break;
            }
        }
        if (avail) {
            Book[] books = bks.getBooks();
        int i = 0;
        for (Book b : books) {
            if (b != null) {
                System.out.println(i + ". " + b.bookInfo());
                i++;
            }
        }
        System.out.print("Enter book number: ");
        i = 0;
        int sel = sc.nextInt();
        Book selBook = new Book(null, null, 0, null, 0);
        for (Book b : books) {
            if (b != null) {
                if (i == sel) {
                    selBook = b;
                    break;
                }
                i++;
            }
        }
        for (int i2 = 0; i2 < userBooks.length; i2++) {
            if (userBooks[i2] == null) {
                userBooks[i2] = new Book(selBook.getTitle(), selBook.getAuthor(), selBook.getYearPublished(), selBook.getIsbn(), 1);
                bks.removeBook(selBook);
                break;
            }
        }
        }else{
            System.out.println("User has too many books");
            cont();
        }
    }
    public void ckIn() {
        User[] users = bks.getUsers();
        int uc = 0;
        for (User u : users) {
            if (u != null) {
                System.out.println(uc + ". " + u.getName());
                uc++;
            }
        }
        System.out.print("Enter user number: ");
        uc = 0;
        int selU = sc.nextInt();
        User user = new User(null, null);
        for (User u : users) {
            if (u != null) {
                if (uc == selU) {
                    user = u;
                    break;
                }
                uc++;
            }
        }
        boolean avail = false;
        Book[] userBooks = user.getBooks();
        for (Book b : userBooks) {
            if (b != null) {
                avail = true;
                break;
            }
        }
        if (avail) {
        int i = 0;
        for (Book b : userBooks) {
            if (b != null) {
                System.out.println(i + ". " + b.bookInfo());
                i++;
            }
        }
        System.out.print("Enter book number: ");
        i = 0;
        int sel = sc.nextInt();
        for (int i2 = 0; i2 < userBooks.length; i2++) {
            if (userBooks[i2] != null) {
                if (i == sel) {
                    boolean t = true;
                    Book[] bksB = bks.getBooks();
                    for (int i3 = 0; i3 < bksB.length; i3++) {
                        if (userBooks[i2].getIsbn().equals(bksB[i3].getIsbn()) && userBooks[i2].getTitle().equals(bksB[i3].getTitle()) && userBooks[i2].getAuthor().equals(bksB[i3].getAuthor()) && userBooks[i2].getYearPublished() == bksB[i3].getYearPublished()) {
                            t = false;
                            bksB[i3].setQuantity(bksB[i3].getQuantity() + 1);
                        }
                    }
                    if (t) {
                        bks.addBook(userBooks[i2]);
                    }
                    userBooks[i2] = null;
                    break;
                }
                i++;
            }
        }
        }else{
            System.out.println("User has no books");
            cont();
        }
    }
    public void cont() {
        System.out.println("Press enter to continue");
        sc.nextLine();
        sc.nextLine();
    }
    public static void main(String[] args) {
        cli cli = new cli();
        cli.run();
    }
}