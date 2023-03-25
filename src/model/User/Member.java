package model.User;

import model.Buyable;
import model.Publication.Book;
import model.Publication.Magazine;
import model.Publication.Publication;

import java.util.ArrayList;

public class Member extends User {

    private final int memberId;
    private double balance;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Magazine> borrowedMagazines;
    private ArrayList<Publication> boughtProducts;
    private static int lastMemberId;

    static {
        lastMemberId = 0;
    }

    {
        balance = 0;
        borrowedBooks = new ArrayList<>();
        borrowedMagazines = new ArrayList<>();
        boughtProducts = new ArrayList<>();
    }

    public Member(String username, String password) {
        super(username, password);
        this.memberId = lastMemberId;
        lastMemberId++;
    }

    public Book getBook(String title) {
        if (borrowedBooks.size() == 0) {
            return null;
        }
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Magazine getMagazine(String title) {
        if (borrowedMagazines.size() == 0) {
            return null;
        }
        for (Magazine magazine : borrowedMagazines) {
            if (magazine.getTitle().equals(title)) {
                return magazine;
            }
        }
        return null;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public ArrayList<Magazine> getBorrowedMagazines() {
        return borrowedMagazines;
    }

    public void setBorrowedMagazines(ArrayList<Magazine> borrowedMagazines) {
        this.borrowedMagazines = borrowedMagazines;
    }

    public ArrayList<Publication> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(ArrayList<Publication> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}
