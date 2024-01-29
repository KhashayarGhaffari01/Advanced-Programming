package Pages;

import java.io.IOException;
import java.util.*;

public class StartPage {
    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have an account?");
        System.out.println("1-Yes, I want to Login.");
        System.out.println("2-No, I want to sign up.");
        String Ans1 = sc.next();
//        Login
        if (Ans1.equals("1")) {
            LoginPage.run();
        }
//        Register
        if (Ans1.equals("2")) {
            IDregisterPage.run();
        }
//        Error
        if (!Ans1.equals("1") && !Ans1.equals("2")) {
            run();
        }
    }
}
