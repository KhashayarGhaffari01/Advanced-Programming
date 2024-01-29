package responses;


import model.UserModel;

public interface ResponseVisitor {

    void changeFrame(String frame);

    void showMessage(String message);

    void setNameLabel(String authToken, String name);

    default void empty() {
    }

    void exit();

    void loginResponse(String response, String authToken);

    void newTweet(String authToken);

    void getUserModel(String authToken, UserModel userModel);
}
