package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import events.NewTweetEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.openjfx.MainApp;
import org.openjfx.listener.EventListener;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewTweetPageFXML implements Initializable {
    public Label nameLabel;
    public TextArea tweetContent;
    private EventListener eventListener;
    private String authToken;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void tweet() throws FileNotFoundException {
//        eventListener.listen(new NewTweetEvent(tweetContent.getText(), Methods.getUserFromID(MainApp.username).getAuthToken(), Methods.getUserFromID(MainApp.username)));
    }

    public void back() {
        eventListener.listen(new ChangeFrameEvent("userPersonalPage"));
    }
}
