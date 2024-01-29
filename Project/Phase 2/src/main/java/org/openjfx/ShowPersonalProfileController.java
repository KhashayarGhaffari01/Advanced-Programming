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
import org.openjfx.main.Methods;

public class ShowPersonalProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    Label FollowingNumberLbl;

    @FXML
    Label FollowerNumberLbl;

    @FXML
    Label NameLbl;

    @FXML
    Label UsenameLbl;

    @FXML
    Label BioLbl;

    @FXML
    Label EmailLbl;

    @FXML
    Label PhoneNumberLbl;

    @FXML
    Label TweetNumberLbl;

    @FXML
    Label PrivateLbl;

    @FXML
    private Button RecentTweetsBtn;

    @FXML
    private Button BackBtn;

    @FXML
    void pressBackBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPersonalPage.fxml"));
        Parent root = fxmlLoader.load();
        UserPersonalPageController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressRecentTweetsBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowTweet.fxml"));
        Parent root = fxmlLoader.load();
        ShowTweetController fxmlController = fxmlLoader.getController();
        fxmlController.TweetsBox.setText(Methods.allTweets(Methods.getUserFromID(MainApp.getUsername)));
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert FollowingNumberLbl != null : "fx:id=\"FollowingNumberLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert FollowerNumberLbl != null : "fx:id=\"FollowerNumberLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert NameLbl != null : "fx:id=\"NameLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert UsenameLbl != null : "fx:id=\"UsenameLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert BioLbl != null : "fx:id=\"BioLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert EmailLbl != null : "fx:id=\"EmailLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert PhoneNumberLbl != null : "fx:id=\"PhoneNumberLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert TweetNumberLbl != null : "fx:id=\"TweetNumberLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert PrivateLbl != null : "fx:id=\"PrivateLbl\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert RecentTweetsBtn != null : "fx:id=\"RecentTweetsBtn\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'ShowPersonalProfile.fxml'.";

    }
}
