package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.Pages.Timeline;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MethodsNew {
    public static void showTweet(int i) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Timeline.fxml"));
        Parent root = fxmlLoader.load();
        TimelineController fxmlController = fxmlLoader.getController();
        fxmlController.UsernameLbl.setText(Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getUser().getID());
        fxmlController.TweetContestArea.setText(Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getContent());
        fxmlController.TweetReactionsArea.setText(Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getLikers().size() + " Likes    " + Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getRetweeters().size() + " ReKhweets");
        if (org.openjfx.main.Methods.getUserFromID(MainApp.getUsername).getBlocks().contains(Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getUser().getID())){
            fxmlController.BlockBtn.setText("UnBlock");
        }
        else {
            fxmlController.BlockBtn.setText("Block");
        }
        if (Timeline.allTweets(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername)).get(i).getLikers().contains(org.openjfx.main.Methods.getUserFromID(MainApp.getUsername))){
            fxmlController.LikeBtn.setText("UnLike");
        }
        else {
            fxmlController.LikeBtn.setText("Like");
        }
        fxmlController.RetweetBtn.setText("ReKhweet");
        Scene scene = new Scene(root);
        MainApp.getStage.setScene(scene);
        MainApp.getStage.show();
    }
}
