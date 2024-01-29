package org.openjfx.Pages;

import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;

public class Notification {
    public static void run(User user) throws IOException {
        System.out.println("1-Follow Requests");
        System.out.println("2-New Followers");
        System.out.println("3-New UnFollows");
        System.out.println("4-Back");
        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (Ans.equals("1")){
            FollowRequests.run(user, 0);
        }
        if (Ans.equals("2")){

        }
        if (Ans.equals("3")){

        }
        if (Ans.equals("4")){
            UserPersonalPage.run(user);
        }
        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4")){
            System.out.println("Invalid Request.");
            run(user);
        }

    }
}
