package org.openjfx.listener;


import events.Event;
import javafx.stage.Stage;
import model.UserModel;
import org.openjfx.graphics.GraphicalAgent;
import responses.Response;
import responses.ResponseVisitor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainController implements ResponseVisitor {
    private final GraphicalAgent graphicalAgent;
    private final EventSender eventSender;
    private final List<Event> events = new LinkedList<>();

    public MainController(EventSender eventSender, Stage stage) throws IOException {
        graphicalAgent = new GraphicalAgent(this::addEvent, eventSender, stage);
        this.eventSender = eventSender;
    }

    public void start() {
        graphicalAgent.initialize();
    }

    private void addEvent(Event event) {
        synchronized (events) {
            Response response = eventSender.send(event);
            if (response != null) {
                response.visit(this);
            }
        }
    }

    @Override
    public void changeFrame(String frame) {
        switch (frame) {
            case "firstPage" -> graphicalAgent.showFirstPage();
            case "loginPage" -> graphicalAgent.showLoginPage();
            case "userPersonalPage" -> graphicalAgent.showUserPersonalPage();
            case "mainMenu" -> graphicalAgent.showMainMenu();
            case "newTweet" -> graphicalAgent.showNewTweetPage();
        }
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void setNameLabel(String authToken, String name) {
        graphicalAgent.mainMenu.getFxmlController().welcomeLabel.setText(name);
    }

    @Override
    public void empty() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void loginResponse(String Error, String authToken) {
        if (!authToken.equals("")) {
            graphicalAgent.setAuthToken(authToken);
            graphicalAgent.showMainMenu();
        }
    }

    @Override
    public void newTweet(String authToken) {
        graphicalAgent.showUserPersonalPage();
    }

    @Override
    public void getUserModel(String authToken, UserModel userModel) {
        graphicalAgent.setUserModel(userModel);
    }
}
