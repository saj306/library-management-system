package view;

import java.util.Scanner;

import java.util.regex.Matcher;

import controller.RegistrationMenuController;
import view.enums.commands.RegistrationMenuCommands;
import view.enums.messages.RegistrationMenuMessages;

public class RegistrationMenu {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine().trim();
            Matcher matcher;
            if (command.equals("exit")) {
                break;
            } else if ((matcher = RegistrationMenuCommands.getMatcher(command, RegistrationMenuCommands.REGISTER_MEMBER)) != null) {
                checkRegisterMember(matcher);
            } else if ((matcher = RegistrationMenuCommands.getMatcher(command, RegistrationMenuCommands.REGISTER_ADMIN)) != null) {
                checkRegisterAdmin(matcher);
            } else if ((matcher = RegistrationMenuCommands.getMatcher(command, RegistrationMenuCommands.LOGIN)) != null) {
                checkLogin(matcher, scanner);
            } else
                System.out.println("invalid command!");
        }
    }

    public static void checkRegisterMember(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        RegistrationMenuMessages message = RegistrationMenuController.checkRegisterMember(username, password);
        switch (message) {
            case USERNAME_EXISTS:
                System.out.println("a user exists with this username");
                break;
            case SUCCESS:
                System.out.println("register successful");
                break;
            default:
                break;
        }
    }

    public static void checkRegisterAdmin(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String role = matcher.group("role");
        RegistrationMenuMessages message = RegistrationMenuController.checkRegisterAdmin(username, password, role);
        switch (message) {
            case USERNAME_EXISTS:
                System.out.println("a user exists with this username");
                break;
            case ROLE_NOT_EXISTS:
                System.out.println("this role not exists");
                break;
            case SUCCESS:
                System.out.println("register successful");
                break;
            default:
                break;
        }
    }

    public static void checkLogin(Matcher matcher, Scanner scanner) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        RegistrationMenuMessages message = RegistrationMenuController.checkLogin(username, password);
        switch (message) {
            case USERNAME_NOT_EXISTS:
                System.out.println("no user exists with this username");
                break;
            case INCORRECT_PASSWORD:
                System.out.println("incorrect password");
                break;
            case LOGIN_SUCCESSFUL_AS_ADMIN:
                System.out.println("login to admin menu successful");
                AdminMenu.run(scanner);
                break;
            case LOGIN_SUCCESSFUL_AS_MEMBER:
                System.out.println("login to member menu successful");
                MemberMenu.run(scanner);
                break;
            default:
                break;
        }
    }


}
