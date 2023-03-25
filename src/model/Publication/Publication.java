package model.Publication;

public class Publication {

    private int publicationId;
    private String title;
    private int numberOfPages;
    private double price;
    private int number;

    private static int lastPublicationId;

    static {
        lastPublicationId = 0;
    }

    public Publication(String title, int numberOfPages, double price, int number) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.number = number;
        this.publicationId = lastPublicationId;
        lastPublicationId++;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String print() {
        return null;
    }
}
