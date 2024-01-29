package database;

import model.User;

public class UserManager extends BaseManager<User, String> {
    private static UserManager userManager;

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
