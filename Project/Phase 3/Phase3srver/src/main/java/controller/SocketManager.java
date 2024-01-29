package controller;

import controller.network.SocketResponseSender;
import resLoader.ConfigLoader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager extends Thread{
    private int port;
    private ConfigLoader configLoader;
    private ServerSocket serverSocket;

    public SocketManager() {
        configLoader = new ConfigLoader("serverConfig");
        port = configLoader.readInteger("port");
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(new SocketResponseSender(socket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}