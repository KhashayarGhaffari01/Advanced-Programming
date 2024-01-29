package model;

public class MainController {
    private static MainController mainController;
    User user;

    private MainController() {
        this.user = new User(user.getID());
    }

    public static MainController getInstance() {

        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
