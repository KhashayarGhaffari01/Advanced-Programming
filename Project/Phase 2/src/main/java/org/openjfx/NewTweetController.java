package org.openjfx;

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
import org.openjfx.main.Methods;
import org.openjfx.main.Tweet;

public class NewTweetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NewTweetBtn;

    @FXML
    private Button Back;

    @FXML
    Label NameLbl;

    @FXML
    private TextArea TweetContestField;

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPersonalPage.fxml"));
        Parent root = fxmlLoader.load();
        UserPersonalPageController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressNewTweetBtn(ActionEvent event) throws IOException {
        String content = TweetContestField.getText();
        Tweet tweet = new Tweet(Methods.getUserFromID(MainApp.getUsername), content);
        Tweet.newTweet(tweet);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPersonalPage.fxml"));
        Parent root = fxmlLoader.load();
        UserPersonalPageController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert NewTweetBtn != null : "fx:id=\"NewTweetBtn\" was not injected: check your FXML file 'NewTweet.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'NewTweet.fxml'.";
        assert NameLbl != null : "fx:id=\"NameLbl\" was not injected: check your FXML file 'NewTweet.fxml'.";
        assert TweetContestField != null : "fx:id=\"TweetContestField\" was not injected: check your FXML file 'NewTweet.fxml'.";

    }
}

