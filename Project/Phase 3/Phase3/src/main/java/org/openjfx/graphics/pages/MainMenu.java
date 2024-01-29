package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class MainMenu {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;



    public MainMenu() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("main_menu.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public MainMenuFXML getFxmlController() {
        return fxmlLoader.getController();
    }

}
