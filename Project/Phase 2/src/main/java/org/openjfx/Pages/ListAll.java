package org.openjfx.Pages;

import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;

public class ListAll {
    static void run(User user) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-Followers");
        System.out.println("2-Followings");
        System.out.println("3-Blocks");
        System.out.println("4-Back");
        String Ans = sc.next();
        if (Ans.equals("1")){
            ListFollowers.run(user);
        }
        if (Ans.equals("2")){
            ListFollowing.run(user);
        }
        if (Ans.equals("3")){
            ListBlocks.run(user);
        }
        if (Ans.equals("4")){
            UserPersonalPage.run(user);
        }
        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4")){
            System.out.println("Invalid request!");
            run(user);
        }
    }
}
