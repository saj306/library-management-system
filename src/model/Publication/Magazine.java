package model.Publication;

public class Magazine extends Publication {

    private String publisher;

    public Magazine(String title, int numberOfPages, double price, String publisher, int number) {
        super(title, numberOfPages, price, number);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
