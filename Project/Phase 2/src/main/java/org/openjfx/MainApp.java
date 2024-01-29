package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;


public class MainApp extends Application {
    static Stage getStage;
    static String getUsername;
    static int getNumberTweet;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));
        Parent root = fxmlLoader.load();
        FXMLController fxmlController = fxmlLoader.getController();
//        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Khwittergram");
        InputStream iconImage = new FileInputStream("photos%20for%20khw/icon.jpg");
        stage.getIcons().add(new Image(iconImage));
        stage.setScene(scene);
        getStage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}