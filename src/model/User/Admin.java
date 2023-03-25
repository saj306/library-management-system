package model.User;

public class Admin extends User {

    private final int adminId;
    private Role role;

    private static int lastAdminId;

    static {
        lastAdminId = 0;
    }

    public Admin(String username, String password, Role role) {
        super(username, password);
        this.role = role;
        this.adminId = lastAdminId;
        lastAdminId++;

    }
}
