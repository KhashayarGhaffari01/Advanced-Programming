package org.openjfx.Pages;

import com.google.gson.Gson;
import org.openjfx.main.Methods;
import org.openjfx.main.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage {
    public static boolean IDExist(String ID) {
        File file = new File("./src/org.openjfx.main/resources/Users/" + ID + ".json");
        return file.exists();
    }

    public static boolean CheckLogin(String ID, String Pass) throws FileNotFoundException {
        Gson gson = new Gson();
        User user = gson.fromJson(new FileReader("./src/org.openjfx.main/resources/Users/" + ID + ".json"), User.class);
        return Pass.equals(user.getPassword());
    }

    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your ID.");
        System.out.println("ID:");
        String ID = sc.next();
        if (IDExist(ID)) {
            System.out.println("Enter your Password:");
            System.out.println("Password:");
            String Password = sc.next();
            if (CheckLogin(ID, Password)) {
                System.out.println("You have successfully login.");
                MainMenu.run(Methods.getUserFromID(ID));
            }
            else {
                System.out.println("Your password is incorrect.");
                StartPage.run();
            }
        }
        else {
            System.out.println("There is no account with this ID.");
            StartPage.run();
        }

    }
}
