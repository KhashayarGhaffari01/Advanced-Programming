package org.openjfx.main;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Comment extends Tweet {
    Tweet tweet;

    public Comment(User user, String content, Tweet tweet) {
        super(user, content);
        this.tweet = tweet;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    public static void newCommentForTweet(Comment comment) throws IOException {
        comment.setTime(LocalDateTime.now());
        comment.setNumber(new File("./src/org.openjfx.main/resources/Comments/" + comment.getTweet().getUser().getID() +  comment.getTweet().getNumber() + "Comments/").listFiles().length+1);
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/org.openjfx.main/resources/Comments/" + comment.getTweet().getUser().getID() + comment.getTweet().getNumber() + "Comments/" + comment.getNumber() +".json");
        gson.toJson(comment, f);
        f.flush();
        List<Comment> tweetComments = comment.tweet.getMentions();
        tweetComments.add(comment);
        comment.tweet.setMentions(tweetComments);
        FileWriter ff = new FileWriter("./src/org.openjfx.main/resources/Tweets/" + comment.tweet.user.getID() + "Tweets/" + comment.tweet.getNumber() + ".json");
        gson.toJson(comment.tweet, ff);
        ff.flush();


    }
}

