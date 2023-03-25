package view;

import controller.AdminMenuController;
import view.enums.commands.AdminMenuCommands;
import view.enums.messages.AdminMenuMessages;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AdminMenu {

    public static void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine().trim();
            Matcher matcher;
            if (command.equals("logout")) {
                break;
            } else if ((matcher = AdminMenuCommands.getMatcher(command, AdminMenuCommands.ADD_REFERENCE_BOOK)) != null) {
                addReferenceBook(matcher);
            } else if ((matcher = AdminMenuCommands.getMatcher(command, AdminMenuCommands.ADD_BORROWABLE_BOOK)) != null) {
                addBorrowableBook(matcher);
            } else if ((matcher = AdminMenuCommands.getMatcher(command, AdminMenuCommands.ADD_SPECIALIZED_MAGAZINE)) != null) {
                addSpecializedMagazine(matcher);
            } else if ((matcher = AdminMenuCommands.getMatcher(command, AdminMenuCommands.ADD_GENERAL_MAGAZINE)) != null) {
                addGeneralMagazine(matcher);
            } else {
                System.out.println("invalid command!");
            }
        }

    }

    private static void addReferenceBook(Matcher matcher) {
        String title = matcher.group("title");
        String author = matcher.group("author");
        String price = matcher.group("price");
        String numberOfPages = matcher.group("numberOfPages");
        String number = matcher.group("number");
        AdminMenuMessages message = AdminMenuController.addReferenceBook(title, author, price, numberOfPages, number);
        switch (message) {
            case SUCCESS:
                System.out.println("add reference book successful");
                break;
            default:
                break;
        }
    }

    private static void addBorrowableBook(Matcher matcher) {
        String title = matcher.group("title");
        String author = matcher.group("author");
        String price = matcher.group("price");
        String numberOfPages = matcher.group("numberOfPages");
        String number = matcher.group("number");
        AdminMenuMessages message = AdminMenuController.addBorrowableBook(title, author, price, numberOfPages, number);
        switch (message) {
            case SUCCESS:
                System.out.println("add borrowable book successful");
                break;
            default:
                break;
        }

    }

    private static void addSpecializedMagazine(Matcher matcher) {
        String title = matcher.group("title");
        String publisher = matcher.group("publisher");
        String price = matcher.group("price");
        String numberOfPages = matcher.group("numberOfPages");
        String number = matcher.group("number");
        AdminMenuMessages message = AdminMenuController.addSpecializedMagazine(title, publisher, price, numberOfPages, number);
        switch (message) {
            case SUCCESS:
                System.out.println("add specialized magazine successful");
                break;
            default:
                break;
        }
    }

    private static void addGeneralMagazine(Matcher matcher) {
        String title = matcher.group("title");
        String publisher = matcher.group("publisher");
        String price = matcher.group("price");
        String numberOfPages = matcher.group("numberOfPages");
        String number = matcher.group("number");
        AdminMenuMessages message = AdminMenuController.addGeneralMagazine(title, publisher, price, numberOfPages, number);
        switch (message) {
            case SUCCESS:
                System.out.println("add general magazine successful");
                break;
            default:
                break;
        }
    }
}
