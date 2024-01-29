package org.openjfx.Pages;

import com.google.gson.Gson;
import org.openjfx.main.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EditProfile {
    public static void run(User user) throws IOException {
        System.out.println("1-Edit ID");
        System.out.println("2-Change privacy");
        System.out.println("3-Edit bio");
        System.out.println("8-Back");

        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (Ans.equals("1")){
            System.out.println("Sorry you can't do this.");
            run(user);
        }
        if (Ans.equals("2")){
            user.setPublic(!user.isPublic());
            Gson gson = new Gson();
            FileWriter f = new FileWriter("./src/org.openjfx.main/resources/Users/" + user.getID() + ".json");
            gson.toJson(user, f);
            f.flush();
            System.out.println("Your privacy has changed.");
            run(user);
        }
//        ...
        if (Ans.equals("8")){
            UserPersonalPage.run(user);
        }
    }
}
