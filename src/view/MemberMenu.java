package view;

import controller.MemberMenuController;
import model.Buyable;
import model.Library;
import model.Publication.Book;
import model.Publication.Magazine;
import model.Publication.Publication;
import model.User.Member;
import view.enums.commands.MemberMenuCommands;
import view.enums.messages.MemberMenuMessages;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MemberMenu {

    public static void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine().trim();
            Matcher matcher;
            if (command.equals("logout")) {
                break;
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.BORROW_BOOK)) != null) {
                borrowBook(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.BORROW_MAGAZINE)) != null) {
                borrowMagazine(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.RETURN_BOOK)) != null) {
                returnBook(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.RETURN_MAGAZINE)) != null) {
                returnMagazine(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.BUY_PUBLICATION)) != null) {
                buyPublication(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.INCREASE_BALANCE)) != null) {
                increaseBalance(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.SHOW_USER_BORROW_BOOKS)) != null) {
                showUserBorrowBooks(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.SHOW_USER_BORROW_MAGAZINES)) != null) {
                showUserBorrowMagazines(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.SHOW_USER_BOUGHT_PUBLICATIONS)) != null) {
                showUserBoughtPublications(matcher);
            } else if ((matcher = MemberMenuCommands.getMatcher(command, MemberMenuCommands.SHOW_ALL_PUBLICATIONS)) != null) {
                showAllPublications(matcher);
            } else {
                System.out.println("invalid command!");
            }
        }

    }


    private static void borrowBook(Matcher matcher) {
        String title = matcher.group("title");
        MemberMenuMessages message = MemberMenuController.borrowBook(title);
        switch (message) {
            case TITLE_NOT_EXISTS:
                System.out.println("there isn't book with this title");
                break;
            case INCORRECT_TYPE:
                System.out.println("this title isn't for book");
                break;
            case NOT_FOR_BORROWING:
                System.out.println("you can't borrow this book");
                break;
            case SUCCESS:
                System.out.println("borrowing the book successfully");
                break;
            default:
                break;
        }
    }

    private static void borrowMagazine(Matcher matcher) {
        String title = matcher.group("title");
        MemberMenuMessages message = MemberMenuController.borrowMagazine(title);
        switch (message) {
            case TITLE_NOT_EXISTS:
                System.out.println("there isn't magazine with this title");
                break;
            case INCORRECT_TYPE:
                System.out.println("this title isn't for magazine");
                break;
            case NOT_FOR_BORROWING:
                System.out.println("you can't borrow this magazine");
                break;
            case SUCCESS:
                System.out.println("borrowing the magazine successfully");
                break;
            default:
                break;
        }

    }

    private static void returnBook(Matcher matcher) {
        String title = matcher.group("title");
        MemberMenuMessages message = MemberMenuController.returnBook(title);
        switch (message) {
            case TITLE_NOT_EXISTS:
                System.out.println("you don't have a book with this title");
                break;
            case SUCCESS:
                System.out.println("returning the book successfully");
                break;
            default:
                break;
        }

    }

    private static void returnMagazine(Matcher matcher) {
        String title = matcher.group("title");
        MemberMenuMessages message = MemberMenuController.returnMagazine(title);
        switch (message) {
            case TITLE_NOT_EXISTS:
                System.out.println("you don't have a magazine with this title");
                break;
            case SUCCESS:
                System.out.println("returning the magazine successfully");
                break;
            default:
                break;
        }
    }

    private static void buyPublication(Matcher matcher) {
        String title = matcher.group("title");
        String number = matcher.group("number");
        MemberMenuMessages message = MemberMenuController.buyPublication(title, number);
        switch (message) {
            case TITLE_NOT_EXISTS:
                System.out.println("there isn't publication with this title");
                break;
            case NOT_FOR_SELLING:
                System.out.println("you can't buy this publication");
                break;
            case INSUFFICIENT_NUMBER:
                System.out.println("not enough products available");
                break;
            case INSUFFICIENT_BALANCE:
                System.out.println("you don't have insufficient balance");
                break;
            case SUCCESS:
                System.out.println("buying the publication successfully");
                break;
            default:
                break;
        }
    }

    private static void increaseBalance(Matcher matcher) {
        String number = matcher.group("number");
        MemberMenuMessages message = MemberMenuController.increaseBalance(number);
        switch (message) {
            case SUCCESS:
                System.out.println("increasing the balance successfully");
                break;
            default:
                break;
        }
    }

    private static void showUserBorrowBooks(Matcher matcher) {
        int number = 1;
        for (Book book : ((Member) Library.getCurrentUser()).getBorrowedBooks()) {
            System.out.println(number + "-" + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: "
                    + book.getPrice());
            number++;
        }
    }

    private static void showUserBorrowMagazines(Matcher matcher) {
        int number = 1;
        for (Magazine magazine : ((Member) Library.getCurrentUser()).getBorrowedMagazines()) {
            System.out.println(number + "-" + magazine.getTitle() + " | Author: " + magazine.getPublisher() + " | Price: "
                    + magazine.getPrice());
            number++;
        }
    }


    private static void showUserBoughtPublications(Matcher matcher) {
        int number = 1;
        for (Publication publication : ((Member) Library.getCurrentUser()).getBoughtProducts()) {
            System.out.println(number + "-" + publication.getTitle() + " | Price: "
                    + publication.getPrice());
            number++;
        }
    }

    private static void showAllPublications(Matcher matcher) {
        int number = 1;
        for (Publication publication : Library.getAllPublications()) {
            System.out.println(number + "-" + publication.print());
            number++;
        }

    }
}
