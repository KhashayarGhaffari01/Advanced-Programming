package Pages;

import com.google.gson.Gson;
import main.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {
    public static boolean IDExist(String ID) {
        File file = new File("./src/main/resources/Users/" + ID + ".json");
        return file.exists();
    }

    public static void run(User user1) throws IOException {
        System.out.println("Enter the id of account you want go to.");
        System.out.println("Enter Back for back.");
        Scanner sc = new Scanner(System.in);
        String Ans = sc.next();
        if (IDExist(Ans)){
            Gson gson = new Gson();
            User user2 = gson.fromJson(new FileReader("./src/main/resources/Users/" + Ans + ".json"), User.class);
            if (!user2.getBlocks().contains(user1.getID())) {
                OtherProfile.run(user2, user1);
            }
            else {
                System.out.println("You were Blocked by this user!");
                run(user1);
            }
        }
        else {
            if (Ans.equals("Back")){
                Explorer.run(user1);
            }
            else {
                System.out.println("This ID does not exist.");
                run(user1);
            }
        }
    }
}
