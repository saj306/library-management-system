package model.Publication;

import model.User.User;

public class Book extends Publication {

    private String author;

    public Book(String title, int numberOfPages, double price, String author, int number) {
        super(title, numberOfPages, price, number);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
