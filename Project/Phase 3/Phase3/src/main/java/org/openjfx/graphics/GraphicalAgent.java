package org.openjfx.graphics;

import events.GetUserModelEvent;
import events.SetNameLabelEvent;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.UserModel;
import org.openjfx.graphics.pages.*;
import org.openjfx.listener.EventListener;
import org.openjfx.listener.EventSender;

import java.io.IOException;

public class GraphicalAgent {
    private String authToken;

    private final EventListener listener;
    private final EventSender eventSender;
    private final Stage stage;
    private UserModel userModel;

    private final FirstPage firstPage = new FirstPage();
    private final LoginPage loginPage = new LoginPage();
    public final MainMenu mainMenu = new MainMenu();
    private final UserPersonalPage userPersonalPage = new UserPersonalPage();
    private final NewTweetPage newTweetPage = new NewTweetPage();

    public GraphicalAgent(EventListener listener, EventSender eventSender, Stage stage) throws IOException {
        this.stage = stage;
        this.listener = listener;
        this.eventSender = eventSender;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void initialize() {
        Platform.runLater(
                () -> {
                    firstPage.getFxmlController().setListener(listener);
                    stage.setTitle("Khwitergram");
                    stage.getIcons().add(new Image("org/openjfx/images/icon.jpg"));
                    stage.setResizable(false);
//                    stage.setOnHidden(e -> {
//                        listener.listen(new LogoutEvent(authToken));
//                        try
//                        {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ignored) {}
//                        stopLoops("");
//                        eventSender.close();
//                        Platform.exit();
//                        System.exit(0);
//                    });
                    stage.show();
                    stage.setScene(firstPage.getScene());
                }
        );
    }

    public void showFirstPage() {
        Platform.runLater(
                () -> {
                    firstPage.getFxmlController().setListener(listener);
                    stage.setScene(firstPage.getScene());
                }
        );
    }

    public void showLoginPage() {
        Platform.runLater(
                () -> {
                    loginPage.getFxmlController().setListener(listener);
                    stage.setScene(loginPage.getScene());
                }
        );
    }

    public void showMainMenu() {
        Platform.runLater(
                () -> {
                    mainMenu.getFxmlController().setListener(listener);
                    listener.listen(new GetUserModelEvent(authToken));
                    mainMenu.getFxmlController().setAuthToken(authToken);
                    mainMenu.getFxmlController().welcomeLabel.setText("Welcome " + userModel.getFirstName());
                    stage.setScene(mainMenu.getScene());
                }
        );
    }

    public void showUserPersonalPage() {
        Platform.runLater(
                () -> {
                    userPersonalPage.getFxmlController().setListener(listener);
                    stage.setScene(userPersonalPage.getScene());
                }
        );
    }

    public void showNewTweetPage() {
        Platform.runLater(
                () -> {
                    newTweetPage.getFxmlController().setListener(listener);
                    newTweetPage.getFxmlController().nameLabel.setText(userModel.getFirstName());
                    stage.setScene(newTweetPage.getScene());
                }
        );
    }
}
