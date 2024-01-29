package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import events.GetUserModelEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.openjfx.listener.EventListener;
import util.Loop;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuFXML implements Initializable {
    public Label welcomeLabel;
    private EventListener eventListener;
    private String authToken = "";
    private Loop loop;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void startLoop()
    {
        loop = new Loop(1, this::update);
        loop.start();
    }

    private void update() {
    }

    public void stopLoop()
    {
        loop.stop();
    }


    public void userPersonalPage() {
        eventListener.listen(new ChangeFrameEvent("userPersonalPage"));
    }

    public void timeline() {
        eventListener.listen(new ChangeFrameEvent("timeline"));
    }

    public void explorer() {
        eventListener.listen(new ChangeFrameEvent("explorer"));
    }

    public void telegram() {
        eventListener.listen(new ChangeFrameEvent("telegram"));
    }

    public void setting() {
        eventListener.listen(new ChangeFrameEvent("setting"));
    }

    public void logout() {
        eventListener.listen(new ChangeFrameEvent("logout"));
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
