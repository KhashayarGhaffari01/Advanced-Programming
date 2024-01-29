package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.fxml.Initializable;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstPageFXML implements Initializable {
    private EventListener eventListener;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    public void login() {
        eventListener.listen(new ChangeFrameEvent("loginPage"));
    }

    public void signUp() {
//            eventListener.listen(new ChangeFrameEvent("signUp"));
    }
}
