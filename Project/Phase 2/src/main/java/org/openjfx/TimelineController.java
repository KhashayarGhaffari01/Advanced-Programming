package org.openjfx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.openjfx.Pages.Timeline;
import org.openjfx.main.Action;
import org.openjfx.main.Methods;

public class TimelineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    Button RetweetBtn;

    @FXML
    Button LikeBtn;

    @FXML
    private Button ReportBtn;

    @FXML
    private Button CommentBtn;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

    @FXML
    private Button OpenTweetBtn;

    @FXML
    private Button BackBtn;

    @FXML
    Label UsernameLbl;

    @FXML
    TextArea TweetContestArea;

    @FXML
    TextArea TweetReactionsArea;

    @FXML
    Button BlockBtn;

    @FXML
    void pressBackBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = fxmlLoader.load();
        MainMenuController fxmlController = fxmlLoader.getController();
        fxmlController.WelcomeLbl.setText("Welcome " + Methods.getUserFromID(MainApp.getUsername).getFirstName());
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressBlockBtn(ActionEvent event) throws IOException {
        if (BlockBtn.getText().equals("Block")) {
            Action.block(Methods.getUserFromID(MainApp.getUsername), Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).get(MainApp.getNumberTweet).getUser());
        } else {
            Action.unblock(Methods.getUserFromID(MainApp.getUsername), Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).get(MainApp.getNumberTweet).getUser());
        }
        MethodsNew.showTweet(MainApp.getNumberTweet);
    }

    @FXML
    void pressCommentBtn(ActionEvent event) {

    }

    @FXML
    void pressLikeBtn(ActionEvent event) throws IOException {
        if (LikeBtn.getText().equals("Like")) {
            Action.like(Methods.getUserFromID(MainApp.getUsername), Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).get(MainApp.getNumberTweet));
        } else {
            Action.unlike(Methods.getUserFromID(MainApp.getUsername), Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).get(MainApp.getNumberTweet));
        }
        MethodsNew.showTweet(MainApp.getNumberTweet);
    }

    @FXML
    void pressNextBtn(ActionEvent event) throws IOException {
        if (MainApp.getNumberTweet + 1 < Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).size()){
            MainApp.getNumberTweet += 1;
            MethodsNew.showTweet(MainApp.getNumberTweet);
        }
    }

    @FXML
    void pressOpenTweetBtn(ActionEvent event) {

    }

    @FXML
    void pressPreviousBtn(ActionEvent event) throws IOException {
        if (MainApp.getNumberTweet > 0){
            MainApp.getNumberTweet -= 1;
            MethodsNew.showTweet(MainApp.getNumberTweet);
        }
    }

    @FXML
    void pressReportBtn(ActionEvent event) {

    }

    @FXML
    void pressRetweetBtn(ActionEvent event) throws IOException {
        Action.retweet(Methods.getUserFromID(MainApp.getUsername), Timeline.allTweets(Methods.getUserFromID(MainApp.getUsername)).get(MainApp.getNumberTweet));
        MethodsNew.showTweet(MainApp.getNumberTweet);
    }

    @FXML
    void initialize() {
        assert RetweetBtn != null : "fx:id=\"RetweetBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert LikeBtn != null : "fx:id=\"LikeBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert ReportBtn != null : "fx:id=\"ReportBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert CommentBtn != null : "fx:id=\"CommentBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert NextBtn != null : "fx:id=\"NextBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert PreviousBtn != null : "fx:id=\"PreviousBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert OpenTweetBtn != null : "fx:id=\"OpenTweetBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert UsernameLbl != null : "fx:id=\"UsernameLbl\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert TweetContestArea != null : "fx:id=\"TweetContestArea\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert TweetReactionsArea != null : "fx:id=\"TweetReactionsArea\" was not injected: check your FXML file 'Timeline.fxml'.";
        assert BlockBtn != null : "fx:id=\"BlockBtn\" was not injected: check your FXML file 'Timeline.fxml'.";

    }
}
