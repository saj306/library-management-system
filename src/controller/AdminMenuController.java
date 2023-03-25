package controller;

import model.Library;
import model.Publication.BorrowableBook;
import model.Publication.GeneralMagazine;
import model.Publication.ReferenceBook;
import model.Publication.SpecializedMagazine;
import view.enums.messages.AdminMenuMessages;

public class AdminMenuController {

    public static AdminMenuMessages addReferenceBook(String title, String author, String price, String numberOfPages, String number) {
        ReferenceBook referenceBook = new ReferenceBook(title, Integer.parseInt(numberOfPages),
                Double.parseDouble(price), author, Integer.parseInt(number));
        Library.addPublication(referenceBook);
        return AdminMenuMessages.SUCCESS;
    }

    public static AdminMenuMessages addBorrowableBook(String title, String author, String price, String numberOfPages, String number) {
        BorrowableBook borrowableBook = new BorrowableBook(title, Integer.parseInt(numberOfPages),
                Double.parseDouble(price), author, Integer.parseInt(number));
        Library.addPublication(borrowableBook);
        return AdminMenuMessages.SUCCESS;
    }

    public static AdminMenuMessages addSpecializedMagazine(String title, String publisher, String price, String numberOfPages, String number) {
        SpecializedMagazine specializedMagazine = new SpecializedMagazine(title, Integer.parseInt(numberOfPages),
                Double.parseDouble(price), publisher, Integer.parseInt(number));
        Library.addPublication(specializedMagazine);
        return AdminMenuMessages.SUCCESS;
    }

    public static AdminMenuMessages addGeneralMagazine(String title, String publisher, String price, String numberOfPages, String number) {
        GeneralMagazine generalMagazine = new GeneralMagazine(title, Integer.parseInt(numberOfPages),
                Double.parseDouble(price), publisher, Integer.parseInt(number));
        Library.addPublication(generalMagazine);
        return AdminMenuMessages.SUCCESS;
    }
}
