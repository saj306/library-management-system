package model.Publication;

public class ReferenceBook extends Book {

    public ReferenceBook(String title, int numberOfPages, double price, String author, int number) {
        super(title, numberOfPages, price, author, number);
    }

    @Override
    public String print() {
        return "<BOOK> | Title: " + this.getTitle() + " | Price: " + this.getPrice() + " | Author: " + this.getAuthor() +
                " | Number: " + this.getNumber();

    }
}
