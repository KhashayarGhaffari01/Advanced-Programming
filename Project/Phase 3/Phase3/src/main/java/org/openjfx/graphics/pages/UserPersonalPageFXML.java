package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class UserPersonalPageFXML implements Initializable {
    public Label welcomeLabel;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void newTweet() {
        eventListener.listen(new ChangeFrameEvent("newTweet"));
    }

    public void userProfile() {
        eventListener.listen(new ChangeFrameEvent("userProfile"));
    }

    public void showLists() {
        eventListener.listen(new ChangeFrameEvent("showLists"));
    }

    public void notifications() {
        eventListener.listen(new ChangeFrameEvent("notifications"));
    }

    public void editProfile() {
        eventListener.listen(new ChangeFrameEvent("editProfile"));
    }

    public void back() {
        eventListener.listen(new ChangeFrameEvent("mainMenu"));
    }
}
