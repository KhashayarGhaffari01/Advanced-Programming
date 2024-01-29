package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class FirstPage {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;

    public FirstPage() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("first_page.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public FirstPageFXML getFxmlController() {
        return fxmlLoader.getController();
    }
}
