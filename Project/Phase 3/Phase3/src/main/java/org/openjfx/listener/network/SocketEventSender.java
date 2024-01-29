package org.openjfx.listener.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import events.Event;
import gson.Deserializer;
import gson.Serializer;
import org.openjfx.listener.EventSender;
import responses.Response;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketEventSender implements EventSender {
    private final PrintStream printStream;
    private final Scanner scanner;
    private final Socket socket;
    private final Gson gson;

    public SocketEventSender(Socket socket) throws IOException {
        this.printStream = new PrintStream(socket.getOutputStream());
        this.scanner = new Scanner(socket.getInputStream());
        this.socket = socket;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Response.class, new Deserializer<>())
                .registerTypeAdapter(Event.class, new Serializer<>())
                .create();
    }

    @Override
    public Response send(Event event) {
        printStream.println(gson.toJson(event, Event.class));
        String line = "null";
        if (scanner.hasNext()) {
            line = scanner.nextLine();
        }
        return gson.fromJson(line, Response.class);
    }

    @Override
    public void close() {
        try {
            printStream.close();
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
