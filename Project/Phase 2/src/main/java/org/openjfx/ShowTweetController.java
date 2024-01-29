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
import javafx.scene.control.TextArea;
import org.openjfx.main.Methods;

public class ShowTweetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    TextArea TweetsBox;

    @FXML
    private Button BackBtn;

    @FXML
    void pressBackBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowPersonalProfile.fxml"));
        Parent root = fxmlLoader.load();
        ShowPersonalProfileController fxmlController = fxmlLoader.getController();
        fxmlController.NameLbl.setText(Methods.getUserFromID(MainApp.getUsername).getFirstName());
        fxmlController.UsenameLbl.setText("@" + Methods.getUserFromID(MainApp.getUsername).getID());
        fxmlController.BioLbl.setText(Methods.getUserFromID(MainApp.getUsername).getBiography());
        fxmlController.EmailLbl.setText(Methods.getUserFromID(MainApp.getUsername).getEmail());
        fxmlController.PhoneNumberLbl.setText(Methods.getUserFromID(MainApp.getUsername).getPhoneNumber());
        if (Methods.getUserFromID(MainApp.getUsername).isPublic()){
            fxmlController.PrivateLbl.setText("Public");
        } else {
            fxmlController.PrivateLbl.setText("Private");
        }
        fxmlController.FollowerNumberLbl.setText(Integer.toString(Methods.getUserFromID(MainApp.getUsername).getFollowers().size()));
        fxmlController.FollowingNumberLbl.setText(Integer.toString(Methods.getUserFromID(MainApp.getUsername).getFollowings().size()));
        fxmlController.TweetNumberLbl.setText(Integer.toString(Methods.getUserFromID(MainApp.getUsername).getTweetNumbers()));
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert TweetsBox != null : "fx:id=\"TweetsBox\" was not injected: check your FXML file 'ShowTweet.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'ShowTweet.fxml'.";

    }
}
