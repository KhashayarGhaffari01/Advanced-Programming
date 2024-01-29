package org.openjfx.Pages;

import org.openjfx.main.Action;
import org.openjfx.main.Methods;
import org.openjfx.main.User;

import java.io.IOException;
import java.util.Scanner;

public class FollowRequests {
    public static void run(User user, int number) throws IOException {
        if (user.getRequests().size()>0) {
            System.out.println(user.getRequests().get(number));
            System.out.println("1-Accept");
            System.out.println("2-Deny");
            System.out.println("3-Next");
            System.out.println("4-Back");
            Scanner sc = new Scanner(System.in);
            String Ans = sc.next();
            if (Ans.equals("1")){
                Action.acceptRequest(user, Methods.getUserFromID(user.getRequests().get(number)));
                System.out.println("Accepted.");
                if (number<user.getRequests().size()) {
                    run(user, number);
                }
                else {
                    Notification.run(user);
                }
            }
            if (Ans.equals("2")){
                Action.denyRequest(user, Methods.getUserFromID(user.getRequests().get(number)));
                System.out.println("Denied.");
                if (number<user.getRequests().size()) {
                    run(user, number);
                }
                else {
                    Notification.run(user);
                }
            }
            if (Ans.equals("3")){
                if (number+1<user.getRequests().size()) {
                    run(user, number+1);
                }
                else {
                    Notification.run(user);
                }
            }
            if (Ans.equals("4")){
                Notification.run(user);
            }
            if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4")){
                System.out.println("Invalid Request.");
                run(user, number);
            }
        }
        else {
            System.out.println("Here is no Requests.");
            Notification.run(user);
        }
    }
}
