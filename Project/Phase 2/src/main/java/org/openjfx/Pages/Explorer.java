package org.openjfx.Pages;

import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;

public class Explorer {
    static void run(User user) throws IOException {
        System.out.println("1-Search");
        System.out.println("2-Explorer Tweets");
        System.out.println("3-Back to Main menu");
        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (Ans.equals("1")){
            Search.run(user);
        }
        if (Ans.equals("2")){

        }
        if (Ans.equals("3")){
            MainMenu.run(user);
        }
        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3")){
            System.out.println("Invalid request!");
            run(user);
        }
    }
}
