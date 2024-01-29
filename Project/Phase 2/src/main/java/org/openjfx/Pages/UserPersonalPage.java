package org.openjfx.Pages;

import com.google.gson.Gson;
import org.openjfx.main.Tweet;
import org.openjfx.main.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserPersonalPage {
    static void run(User user) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-New Tweet");
        System.out.println("2-Show recent tweets");
        System.out.println("3-Your lists");
        System.out.println("4-info");
        System.out.println("5-Notifications");
        System.out.println("6-Edit profile");
        System.out.println("7-Back to Main menu");
        String Ans = sc.next();
        if (Ans.equals("1")) {
            System.out.println("Write your tweet:");
            String chert = sc.nextLine();
            String content = sc.nextLine();
            Tweet tweet = new Tweet(user, content);
            Tweet.newTweet(tweet);
            run(user);
        }
        if (Ans.equals("2")) {
            System.out.println("Enter something for back.");
            Gson gson = new Gson();
            for (int i = user.getTweetNumbers(); i > 0; i--) {
                Tweet.printTweetHomepage(gson.fromJson(new FileReader("./src/main/resources/Tweets/" + user.getID() + "Tweets/" + i + ".json"), Tweet.class));
            }
            String something = sc.next();
            run(user);
        }
        if (Ans.equals("3")) {
            ListAll.run(user);
        }
        if (Ans.equals("4")) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
            System.out.println(user.getBiography());
            System.out.println(user.getEmail());
            run(user);
        }
        if (Ans.equals("5")) {
            Notification.run(user);
        }
        if (Ans.equals("6")){
            EditProfile.run(user);
        }
        if (Ans.equals("7")) {
            MainMenu.run(user);
        }
        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5") && !Ans.equals("6") && !Ans.equals("7")) {
            System.out.println("Invalid request!");
            run(user);
        }
    }
}

