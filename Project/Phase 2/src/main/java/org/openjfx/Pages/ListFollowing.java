package org.openjfx.Pages;

import org.openjfx.main.Methods;
import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;


public class ListFollowing {
    static void run(User user) throws IOException {
        for (String ID : user.getFollowings()) {
            System.out.println(ID);
        }
        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (Ans.equals("Back")) {
            ListAll.run(user);
        } else {
            int i = 0;
            for (String ID : user.getFollowings()) {
                i++;
                if (Ans.equals(ID)) {
                    User user2 = Methods.getUserFromID(Ans);
                    OtherProfile.run(user2, user);
                }
            }
            if (i == user.getFollowings().size()) {
                System.out.println("Invalid");
                run(user);
            }

        }

    }
}
