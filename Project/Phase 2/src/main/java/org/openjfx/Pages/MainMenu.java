package org.openjfx.Pages;

import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    static void run(User user) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to org.openjfx.main menu of Khwittergram.");
        System.out.println("1-My Page");
        System.out.println("2-Timeline");
        System.out.println("3-Explorer");
        System.out.println("4-Telegram");
        System.out.println("5-Setting");
        System.out.println("6-Log out");
        String Ans = sc.next();
        if (Ans.equals("1")){
            UserPersonalPage.run(user);
        }
        if (Ans.equals("2")){
            Timeline.run(user, 0);
        }
        if (Ans.equals("3")){
            Explorer.run(user);
        }
        if (Ans.equals("4")){
            Telegram.run(user);
        }
        if (Ans.equals("5")){
            Setting.run(user);
        }
        if (Ans.equals("6")){
            StartPage.run();
        }
        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5") && !Ans.equals("6")){
            System.out.println("Invalid request!");
            run(user);
        }
    }
}
