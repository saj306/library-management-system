package model.User;

public abstract class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private final int userId;

    private static int lastUserId;

    static {
        lastUserId = 0;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userId = lastUserId;
        lastUserId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public static int getLastUserId() {
        return lastUserId;
    }

    public static void setLastUserId(int lastUserId) {
        User.lastUserId = lastUserId;
    }
}
