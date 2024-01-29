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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FollowersListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SearchField;

    @FXML
    TextArea FollowersArea;

    @FXML
    private Button BackBtn;

    @FXML
    void pressBackBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Lists.fxml"));
        Parent root = fxmlLoader.load();
        ListsController fxmlController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert SearchField != null : "fx:id=\"SearchField\" was not injected: check your FXML file 'FollowersList.fxml'.";
        assert FollowersArea != null : "fx:id=\"FollowersArea\" was not injected: check your FXML file 'FollowersList.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'FollowersList.fxml'.";

    }
}
