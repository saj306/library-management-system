package model.Publication;

import model.Borrowable;
import model.Buyable;

public class GeneralMagazine extends Magazine implements Borrowable, Buyable {

    public GeneralMagazine(String title, int numberOfPages, double price, String publisher, int number) {
        super(title, numberOfPages, price, publisher, number);
    }


    @Override
    public void sendReminderSMS() {
        System.out.println("You have two weeks to return the book");
    }

    @Override
    public void sendSMS() {
        System.out.println("your magazine purchase with price " + this.getPrice() + " was successful");
    }

    @Override
    public void printReport() {
        System.out.println("A magazine named " + this.getTitle() + " was purchased from the store");

    }

    @Override
    public String print() {
        return "<MAGAZINE> | Title: " + this.getTitle() + " | Price: " + this.getPrice() + " | Publisher: " + this.getPublisher() +
                " | Number: " + this.getNumber();

    }
}
