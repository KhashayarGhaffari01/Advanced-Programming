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
import org.openjfx.main.Methods;

public class ListsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button FollowersBtn;

    @FXML
    private Button FollowingsBtn;

    @FXML
    private Button BlocksBtn;

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
    void pressBlocksBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BlocksList.fxml"));
        Parent root = fxmlLoader.load();
        BlocksListController fxmlController = fxmlLoader.getController();
        fxmlController.BlocksArea.setText(Methods.BlocksList(Methods.getUserFromID(MainApp.getUsername)));
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressFollowersBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FollowersList.fxml"));
        Parent root = fxmlLoader.load();
        FollowersListController fxmlController = fxmlLoader.getController();
        fxmlController.FollowersArea.setText(Methods.FollowersList(Methods.getUserFromID(MainApp.getUsername)));
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void pressFollowingsBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FollowingsList.fxml"));
        Parent root = fxmlLoader.load();
        FollowingsListController fxmlController = fxmlLoader.getController();
        fxmlController.FollowingsArea.setText(Methods.FollowingsList(Methods.getUserFromID(MainApp.getUsername)));
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }

    @FXML
    void initialize() {
        assert FollowersBtn != null : "fx:id=\"FollowersBtn\" was not injected: check your FXML file 'Lists.fxml'.";
        assert FollowingsBtn != null : "fx:id=\"FollowingsBtn\" was not injected: check your FXML file 'Lists.fxml'.";
        assert BlocksBtn != null : "fx:id=\"BlocksBtn\" was not injected: check your FXML file 'Lists.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'Lists.fxml'.";

    }
}
