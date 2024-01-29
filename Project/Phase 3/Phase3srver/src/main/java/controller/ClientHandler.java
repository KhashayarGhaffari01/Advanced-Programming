package controller;

import database.TokenManager;
import database.TweetManager;
import database.UserManager;
import events.Event;
import events.EventVisitor;
import model.Tweet;
import model.User;
import model.UserModel;
import responses.*;
import util.Token;
import util.TokenGenerator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ClientHandler extends Thread implements EventVisitor {
    private final ResponseSender responseSender;
    private volatile boolean running = true;
    private final TokenGenerator tokenGenerator = new TokenGenerator();
    private String authToken;

    @Override
    public void run() {
        while (running) {
            Event event = responseSender.getEvent();
            Response response = event.visit(this);
            responseSender.sendResponse(response);
        }
    }

    private User user;

    public ClientHandler(ResponseSender responseSender) throws IOException {
        this.responseSender = responseSender;
    }

    @Override
    public Response changeFrame(String frame) {
        return new ChangeFrameResponse(frame);
    }

    @Override
    public Response login(String username, String password) {
        System.out.println("5");
        user = UserManager.getInstance().fetch(username);
        System.out.println("7");
        if (user == null) {
            System.out.println("1");
            return new LoginResponse("wrong username", "");
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("2");
            return new LoginResponse("wrong password", "");
        }
        if (user.isOnline()) {
            System.out.println("3");
            return new LoginResponse("online", "");
        }
        System.out.println("444");
        authToken = tokenGenerator.newToken();
        user.setOnline(true);
        Token token = new Token(authToken);
        token.setUser(user);
        TokenManager.getInstance().save(token);
        return new LoginResponse("", authToken);
    }

    @Override
    public Response newTweet(String content, String authToken) {
        Token token = TokenManager.getInstance().fetch(authToken);
        user = token.getUser();
        Tweet tweet = new Tweet(user, content);
        TweetManager.getInstance().save(tweet);
        return new NewTweetResponse(authToken);
    }

    @Override
    public Response setNameLabel(String authToken) {
        return new SetNameLabelResponse(authToken, TokenManager.getInstance().fetch(authToken).getUser().getFirstName());
    }

    @Override
    public Response getUserModel(String authToken) {
        Token token = TokenManager.getInstance().fetch(authToken);
        user = token.getUser();
        UserModel userModel = new UserModel(user.getID());
        userModel.setBiography(user.getBiography());
        userModel.setEmailAddress(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPhoneNumber(user.getPhoneNumber());
//        List<String> following = new LinkedList<>();
//        for (User user1 : user.getFollowings()
//        ) {
//            following.add(user1.getID());
//        }
//        userModel.setFollowings(following);
//        List<String> follower = new LinkedList<>();
//        for (User user1 : user.getFollowers()
//        ) {
//            follower.add(user1.getID());
//        }
//        userModel.setFollowers(follower);
//        List<String> block = new LinkedList<>();
//        for (User user1 : user.getBlocks()
//        ) {
//            block.add(user1.getID());
//        }
//        userModel.setBlocks(block);
//        List<String> request = new LinkedList<>();
//        for (User user1 : user.getRequests()
//        ) {
//            request.add(user1.getID());
//        }
//        userModel.setRequests(request);
        return new GetUserModelResponse(authToken, userModel);
    }
}
