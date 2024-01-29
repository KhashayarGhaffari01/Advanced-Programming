package main;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Methods {
    public static User getUserFromID(String ID) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader("./src/main/resources/Users/" + ID + ".json"), User.class);
    }
}
