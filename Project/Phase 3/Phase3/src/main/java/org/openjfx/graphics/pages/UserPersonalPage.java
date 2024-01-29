package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class UserPersonalPage {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;



    public UserPersonalPage() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("user_personal_page.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public UserPersonalPageFXML getFxmlController() {
        return fxmlLoader.getController();
    }

}
