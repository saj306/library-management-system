package model.Publication;

import model.Borrowable;
import model.Buyable;

public class BorrowableBook extends Book implements Borrowable, Buyable {

    public BorrowableBook(String title, int numberOfPages, double price, String author, int number) {
        super(title, numberOfPages, price, author, number);
    }

    @Override
    public void sendReminderSMS() {
        System.out.println("You have two weeks to return the book");
    }

    @Override
    public void sendSMS() {
        System.out.println("your book purchase with price " + this.getPrice() + " was successful");
    }

    @Override
    public void printReport() {
        System.out.println("A book named " + this.getTitle() + " was purchased from the store");

    }

    @Override
    public String print() {
        return "<BOOK> | Title: " + this.getTitle() + " | Price: " + this.getPrice() + " | Author: " + this.getAuthor() +
                " | Number: " + this.getNumber();

    }
}
