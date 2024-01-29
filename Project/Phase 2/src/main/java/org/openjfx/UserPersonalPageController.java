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
import org.openjfx.main.Methods;

public class UserPersonalPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NewTweetBtn;

    @FXML
    private Button UserProfileBtn;

    @FXML
    private Button ListsBtn;

    @FXML
    private Button NotificationsBtn;

    @FXML
    private Button EditProfileBtn;

    @FXML
    private Button BackBtn;

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
    void pressEditProfileBtn(ActionEvent event) {

    }

    @FXML
    void pressListsBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Lists.fxml"));
        Parent root = fxmlLoader.load();
        ListsController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressNewTweetBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTweet.fxml"));
        Parent root = fxmlLoader.load();
        NewTweetController fxmlController = fxmlLoader.getController();
        fxmlController.NameLbl.setText(Methods.getUserFromID(MainApp.getUsername).getFirstName());
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressNotificationsBtn(ActionEvent event) {

    }

    @FXML
    void pressUserProfileBtn(ActionEvent event) throws IOException {
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
        assert NewTweetBtn != null : "fx:id=\"NewTweetBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";
        assert UserProfileBtn != null : "fx:id=\"UserProfileBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";
        assert ListsBtn != null : "fx:id=\"ListsBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";
        assert NotificationsBtn != null : "fx:id=\"NotificationsBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";
        assert EditProfileBtn != null : "fx:id=\"EditProfileBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'UserPersonalPage.fxml'.";

    }
}
