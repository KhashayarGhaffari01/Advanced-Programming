package Pages;

import main.Methods;
import main.User;

import java.io.IOException;
import java.util.Scanner;

public class ListFollowers {
    static void run(User user) throws IOException {
        for (String ID : user.getFollowers()) {
            System.out.println(Methods.getUserFromID(ID).getID());
        }
        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (Ans.equals("Back")) {
            ListAll.run(user);
        } else {
            int i = 0;
            for (String ID : user.getFollowers()) {
                i++;
                if (Ans.equals(Methods.getUserFromID(ID).getID())) {
                    User user2 = Methods.getUserFromID(Ans);
                    OtherProfile.run(user2, user);
                }
            }
            if (i == user.getFollowers().size()){
                System.out.println("Invalid");
                run(user);
            }
        }
    }
}
