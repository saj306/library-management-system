package model;

import model.Publication.Publication;

import model.User.User;

import java.util.ArrayList;

public class Library {
    private static ArrayList<User> allUsers;
    private static ArrayList<Publication> allPublications;
    private static User currentUser;


    static {
        allUsers = new ArrayList<>();
        allPublications = new ArrayList<>();
        currentUser = null;
    }

    public static User getUser(String username) {
        if (allUsers.size() == 0) {
            return null;
        }
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static Publication getPublication(String title) {
        if (allPublications.size() == 0) {
            return null;
        }
        for (Publication publication : allPublications) {
            if (publication.getTitle().equals(title)) {
                return publication;
            }
        }
        return null;
    }

    public static void addUser(User user) {
        allUsers.add(user);
    }

    public static void addPublication(Publication publication) {
        allPublications.add(publication);
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        Library.allUsers = allUsers;
    }

    public static ArrayList<Publication> getAllPublications() {
        return allPublications;
    }

    public static void setAllPublications(ArrayList<Publication> allPublications) {
        Library.allPublications = allPublications;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Library.currentUser = currentUser;
    }
}
