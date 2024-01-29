package Pages;

import Pages.StartPage;
import main.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IDregisterPage {
    public static boolean IDExist(String ID) {
        File file = new File("./src/main/resources/Users/" + ID + ".json");
        return file.exists();
    }

    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your ID.");
        System.out.println("Your ID must have alphabet and number.");
        System.out.println("Enter 0 for back.");
        System.out.println("ID:");
        String id = sc.next();
        if (id.equals("0")) {
            StartPage.run();
        } else {
            if (IDExist(id)) {
                System.out.println("This ID is chosen by someone else, choose another one");
                run();
            } else {
                User user = new User(id);
                RegisterPage.run(user);
            }
        }
    }
}
