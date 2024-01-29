package org.openjfx;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.openjfx.Pages.IDregisterPage;
import org.openjfx.main.Methods;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

public class LoginPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private ImageView ErrorImage;

    @FXML
    void pressBackAct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));
        Parent root = fxmlLoader.load();
        FXMLController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressLogonAct(ActionEvent event) throws IOException {
        String userId = usernameTextField.getText();
        if (IDregisterPage.IDExist(userId)){
            if (Methods.getUserFromID(userId).getPassword().equals(passwordTextField.getText())){
//                Successful Login
                MainApp.getUsername = userId;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent root = fxmlLoader.load();
                MainMenuController fxmlController = fxmlLoader.getController();
                fxmlController.WelcomeLbl.setText("Welcome " + Methods.getUserFromID(MainApp.getUsername).getFirstName());
                Scene scene = new Scene(root);
                MainApp.getStage.setScene(scene);
                MainApp.getStage.show();
            }
            else {
//                Wrong Password
                InputStream imageFile = new FileInputStream("photos%20for%20khw/ErrorPassword.jpg");
                ErrorImage.setImage(new Image(imageFile));
            }
        }
        else {
//        Wrong Username
            InputStream imageFile = new FileInputStream("photos%20for%20khw/ErrorUsername.jpg");
            ErrorImage.setImage(new Image(imageFile));
        }

    }

    @FXML
    void initialize() {
        assert usernameTextField != null : "fx:id=\"usernameTextField\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'LoginPage.fxml'.";

    }
}
