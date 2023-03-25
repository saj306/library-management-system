package controller;

import model.Borrowable;
import model.Buyable;
import model.Library;
import model.Publication.Book;
import model.Publication.Magazine;
import model.Publication.Publication;
import model.User.Member;
import view.enums.messages.MemberMenuMessages;

public class MemberMenuController {

    public static MemberMenuMessages borrowBook(String title) {
        Publication publication;
        if ((publication = Library.getPublication(title)) == null) {
            return MemberMenuMessages.TITLE_NOT_EXISTS;
        } else if (publication instanceof Magazine) {
            return MemberMenuMessages.INCORRECT_TYPE;
        } else if (!(publication instanceof Borrowable)) {
            return MemberMenuMessages.NOT_FOR_BORROWING;
        }
        ((Member) Library.getCurrentUser()).getBorrowedBooks().add((Book) publication);
        publication.setNumber(publication.getNumber() - 1);
        ((Borrowable) publication).sendReminderSMS();

        return MemberMenuMessages.SUCCESS;
    }

    public static MemberMenuMessages borrowMagazine(String title) {
        Publication publication;
        if ((publication = Library.getPublication(title)) == null) {
            return MemberMenuMessages.TITLE_NOT_EXISTS;
        } else if (publication instanceof Book) {
            return MemberMenuMessages.INCORRECT_TYPE;
        } else if (!(publication instanceof Borrowable)) {
            return MemberMenuMessages.NOT_FOR_BORROWING;
        }
        ((Member) Library.getCurrentUser()).getBorrowedMagazines().add((Magazine) publication);
        publication.setNumber(publication.getNumber() - 1);
        ((Borrowable) publication).sendReminderSMS();

        return MemberMenuMessages.SUCCESS;
    }

    public static MemberMenuMessages returnBook(String title) {
        Book book;
        if ((book = ((Member) Library.getCurrentUser()).getBook(title)) == null) {
            return MemberMenuMessages.TITLE_NOT_EXISTS;
        }
        ((Member) Library.getCurrentUser()).getBorrowedBooks().remove(book);
        book.setNumber(book.getNumber() + 1);

        return MemberMenuMessages.SUCCESS;
    }

    public static MemberMenuMessages returnMagazine(String title) {
        Magazine magazine;
        if ((magazine = ((Member) Library.getCurrentUser()).getMagazine(title)) == null) {
            return MemberMenuMessages.TITLE_NOT_EXISTS;
        }
        ((Member) Library.getCurrentUser()).getBorrowedMagazines().remove(magazine);
        magazine.setNumber(magazine.getNumber() + 1);

        return MemberMenuMessages.SUCCESS;
    }

    public static MemberMenuMessages buyPublication(String title, String number) {
        Member member = (Member) Library.getCurrentUser();
        int tempNumber = Integer.parseInt(number);
        Publication publication;
        if ((publication = Library.getPublication(title)) == null) {
            return MemberMenuMessages.TITLE_NOT_EXISTS;
        } else if (!(publication instanceof Buyable)) {
            return MemberMenuMessages.NOT_FOR_SELLING;
        } else if (publication.getNumber() < tempNumber) {
            return MemberMenuMessages.INSUFFICIENT_NUMBER;
        } else if (member.getBalance() < (tempNumber * publication.getPrice())) {
            return MemberMenuMessages.INSUFFICIENT_BALANCE;
        }
        member.getBoughtProducts().add(publication);
        member.setBalance(member.getBalance() - (tempNumber * publication.getPrice()));
        publication.setNumber(publication.getNumber() - tempNumber);

        ((Buyable) publication).sendSMS();
        ((Buyable) publication).printReport();

        return MemberMenuMessages.SUCCESS;
    }

    public static MemberMenuMessages increaseBalance(String number) {
        int tempNumber = Integer.parseInt(number);
        Member member = (Member) Library.getCurrentUser();
        member.setBalance(member.getBalance() + tempNumber);
        return MemberMenuMessages.SUCCESS;
    }
}
