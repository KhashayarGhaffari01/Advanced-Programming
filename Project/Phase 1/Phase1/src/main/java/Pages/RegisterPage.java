package Pages;

import Pages.IDregisterPage;
import Pages.StartPage;
import com.google.gson.Gson;
import main.Date;
import main.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class RegisterPage {
    public static void run(User user) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fill the items below and enter 'Back' for previous page.");
        System.out.println("Stared are necessary.");
        System.out.println("FisrtName:");
        String Ans1 = sc.next();
        if (Ans1.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setFirstName(Ans1);
        }
        System.out.println("LastName:");
        String Ans2 = sc.next();
        if (Ans2.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setLastName(Ans2);
        }
        System.out.println("Email Address:");
        String Ans3 = sc.next();
        if (Ans3.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setEmail(Ans3);
        }
        System.out.println("Phone Number:");
        String Ans4 = sc.next();
        if (Ans4.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setPhoneNumber(Ans4);
        }
        System.out.println("Year of Birthday:");
        String Ans5 = sc.next();
        int year = Integer.parseInt(Ans5);
        System.out.println("Month of Birthday:");
        String Ans6 = sc.next();
        int month = Integer.parseInt(Ans6);
        System.out.println("Day of Birthday:");
        String Ans7 = sc.next();
        int day = Integer.parseInt(Ans7);
        user.setBirthday(new Date(year, month, day));
        System.out.println("Biography:");
        String chert = sc.nextLine();
        String Ans8 = sc.nextLine();
        if (Ans8.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setBiography(Ans8);
        }
        System.out.println("Password:");
        String Ans9 = sc.next();
        if (Ans9.equals("back")) {
            IDregisterPage.run();
        } else {
            user.setPassword(Ans9);
        }
        user.setTweetNumbers(0);
        user.setPublic(true);
        user.setFollowers(new LinkedList<>());
        user.setFollowings(new LinkedList<>());
        user.setBlocks(new LinkedList<>());
        user.setRequests(new LinkedList<>());
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Users/" + user.getID() + ".json");
        gson.toJson(user, f);
        f.flush();
        System.out.println("Congratulations! Your account has created.");
        File file = new File("./src/main/resources/Tweets/" + user.getID() + "Tweets/");
        file.mkdirs();
        StartPage.run();
    }
}
