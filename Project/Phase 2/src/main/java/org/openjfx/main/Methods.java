package org.openjfx.main;

import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.MainApp;
import org.openjfx.Pages.Timeline;
import org.openjfx.TimelineController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ref.SoftReference;

public class Methods {
    public static User getUserFromID(String ID) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader("./src/main/resources/Users/" + ID + ".json"), User.class);
    }
    public static String allTweets(User user) throws FileNotFoundException {
        String res = "";
        Gson gson = new Gson();
        for (int i = user.getTweetNumbers(); i > 0; i--) {
            res += (gson.fromJson(new FileReader("./src/main/resources/Tweets/" + user.getID() + "Tweets/" + i + ".json"), Tweet.class)).content;
            res += "\n";
            res += (gson.fromJson(new FileReader("./src/main/resources/Tweets/" + user.getID() + "Tweets/" + i + ".json"), Tweet.class)).getLikers().size() + " Likes     ";
            res += (gson.fromJson(new FileReader("./src/main/resources/Tweets/" + user.getID() + "Tweets/" + i + ".json"), Tweet.class)).getRetweeters().size() + " ReKhweets     ";
            res += "\n";
            res += "\n";
            res += "\n";
        }
        return res;
    }
    public static String FollowersList(User user){
        String res = "";
        for (int i = 0; i < user.getFollowers().size(); i++){
            res += user.getFollowers().get(i);
            res += "\n";
        }
        return res;
    }
    public static String FollowingsList(User user){
        String res = "";
        for (int i = 0; i < user.getFollowings().size(); i++){
            res += user.getFollowings().get(i);
            res += "\n";
        }
        return res;
    }
    public static String BlocksList(User user){
        String res = "";
        for (int i = 0; i < user.getBlocks().size(); i++){
            res += user.getBlocks().get(i);
            res += "\n";
        }
        return res;
    }


}
