package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class LoginPage {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;



    public LoginPage() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("login_page.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public LoginPageFXML getFxmlController() {
        return fxmlLoader.getController();
    }

}
