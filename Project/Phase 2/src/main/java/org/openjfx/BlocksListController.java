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

public class BlocksListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SearchField;

    @FXML
    TextArea BlocksArea;

    @FXML
    private Button BackBtn;

    @FXML
    private Button SearchBtn;

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
    void pressSearchBtn(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SearchField != null : "fx:id=\"SearchField\" was not injected: check your FXML file 'BlocksList.fxml'.";
        assert BlocksArea != null : "fx:id=\"BlocksArea\" was not injected: check your FXML file 'BlocksList.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'BlocksList.fxml'.";
        assert SearchBtn != null : "fx:id=\"SearchBtn\" was not injected: check your FXML file 'BlocksList.fxml'.";

    }
}
