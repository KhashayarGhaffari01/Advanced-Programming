package org.openjfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openjfx.listener.MainController;
import org.openjfx.listener.network.SocketEventSender;
import resLoader.ConfigLoader;

import java.io.IOException;
import java.net.Socket;


public class MainApp extends Application {
    private int port;
    private ConfigLoader configLoader;
    private String host;

    public MainApp() throws IOException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        configLoader = new ConfigLoader("clientConfig");
        port = configLoader.readInteger("port");
        host = configLoader.readString("host");
        Socket socket = new Socket(host, port);
        MainController mainController = new MainController(new SocketEventSender(socket), stage);
        mainController.start();
//
//        Parent root = FXMLLoader.load(getClass().getResource("first_page.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//
//        stage.setTitle("JavaFX and Gradle");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}