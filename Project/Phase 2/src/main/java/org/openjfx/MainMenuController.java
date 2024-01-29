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
import org.openjfx.Pages.Timeline;
import org.openjfx.main.Methods;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button UserPersonalPageBtn;

    @FXML
    private Button TimelineBtn;

    @FXML
    private Button ExplorerBtn;

    @FXML
    private Button TelegramBtn;

    @FXML
    private Button SettingBtn;

    @FXML
    private Button LogoutBtn;

    @FXML
    Label WelcomeLbl;

    @FXML
    void PressExplorerBtn(ActionEvent event) {

    }

    @FXML
    void PressLogoutBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = fxmlLoader.load();
        LoginPageController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();

    }

    @FXML
    void PressSettingBtn(ActionEvent event) {
    }

    @FXML
    void PressTelegramBtn(ActionEvent event) {

    }

    @FXML
    void PressTimelineBtn(ActionEvent event) throws IOException {
        MethodsNew.showTweet(0);
    }

    @FXML
    void PressUserPersonalPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPersonalPage.fxml"));
        Parent root = fxmlLoader.load();
        UserPersonalPageController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert UserPersonalPageBtn != null : "fx:id=\"UserPersonalPageBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert TimelineBtn != null : "fx:id=\"TimelineBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert ExplorerBtn != null : "fx:id=\"ExplorerBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert TelegramBtn != null : "fx:id=\"TelegramBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert SettingBtn != null : "fx:id=\"SettingBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert LogoutBtn != null : "fx:id=\"LogoutBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert WelcomeLbl != null : "fx:id=\"WelcomeLbl\" was not injected: check your FXML file 'MainMenu.fxml'.";

    }
}
