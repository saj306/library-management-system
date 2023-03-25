package controller;

import model.Library;
import model.User.Admin;
import model.User.Member;
import model.User.Role;
import view.enums.messages.RegistrationMenuMessages;

public class RegistrationMenuController {

    public static RegistrationMenuMessages checkRegisterMember(String username, String password) {
        if (Library.getUser(username) != null) {
            return RegistrationMenuMessages.USERNAME_EXISTS;
        }
        Member member = new Member(username, password);
        Library.addUser(member);
        return RegistrationMenuMessages.SUCCESS;
    }

    public static RegistrationMenuMessages checkRegisterAdmin(String username, String password, String role) {
        if (Library.getUser(username) != null) {
            return RegistrationMenuMessages.USERNAME_EXISTS;
        }
        if (!role.equals("central management") & !role.equals("department manager") & !role.equals("warehouse keeper") & !role.equals("technical support")) {
            return RegistrationMenuMessages.ROLE_NOT_EXISTS;
        }
        Role tempRole;
        if (role.equals("central management")) {
            tempRole = Role.CENTRAL_MANAGEMENT;
        } else if (role.equals("department manager")) {
            tempRole = Role.DEPARTMENT_MANAGER;
        } else if (role.equals("warehouse keeper")) {
            tempRole = Role.WAREHOUSE_KEEPER;
        } else {
            tempRole = Role.TECHNICAL_SUPPORT;
        }
        Admin admin = new Admin(username, password, tempRole);
        Library.addUser(admin);
        return RegistrationMenuMessages.SUCCESS;
    }

    public static RegistrationMenuMessages checkLogin(String username, String password) {

        if (Library.getUser(username) == null) {
            return RegistrationMenuMessages.USERNAME_NOT_EXISTS;
        } else if (!(Library.getUser(username).getPassword().equals(password))) {
            return RegistrationMenuMessages.INCORRECT_PASSWORD;
        } else if (Library.getUser(username) instanceof Admin) {
            Library.setCurrentUser(Library.getUser(username));
            return RegistrationMenuMessages.LOGIN_SUCCESSFUL_AS_ADMIN;
        }
        Library.setCurrentUser(Library.getUser(username));
        return RegistrationMenuMessages.LOGIN_SUCCESSFUL_AS_MEMBER;
    }


}
