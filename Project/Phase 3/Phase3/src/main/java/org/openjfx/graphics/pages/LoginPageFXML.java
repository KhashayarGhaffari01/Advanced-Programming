package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import events.LoginEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageFXML implements Initializable {
    private EventListener eventListener;
    public TextField usernameField;
    public PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    public void back() {
        eventListener.listen(new ChangeFrameEvent("firstPage"));
    }

    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        eventListener.listen(new LoginEvent(username, password));
    }
}
