package org.openjfx.main;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Tweet implements Comparable<Tweet> {
    User user;
    String content;

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
    }

    int like;
    int Retweet;
    java.time.LocalDateTime Time;
    List<User> likers;
    List<User> retweeters;
    int number;
    List<Comment> Mentions;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getRetweet() {
        return Retweet;
    }

    public void setRetweet(int retweet) {
        Retweet = retweet;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime time) {
        Time = time;
    }

    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }

    public List<User> getRetweeters() {
        return retweeters;
    }

    public void setRetweeters(List<User> retweeters) {
        this.retweeters = retweeters;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Comment> getMentions() {
        return Mentions;
    }

    public void setMentions(List<Comment> mentions) {
        Mentions = mentions;
    }

    public static void printTweetHomepage(Tweet tweet) {
        System.out.println(Color.YELLOW_BOLD +  tweet.user.getID());
        System.out.println(Color.BLUE + tweet.content);
        System.out.println(Color.GREEN_BACKGROUND + Color.BLACK_BOLD + tweet.getRetweeters().size() + Color.GREEN + " Retweets" + "   " + Color.RED_BACKGROUND + Color.BLACK_BOLD + tweet.getLikers().size() + Color.RED + " Likes" + Color.RESET);
        System.out.println();
    }

    public static void newTweet(Tweet tweet) throws IOException {
        tweet.setTime(LocalDateTime.now());
        Gson gson = new Gson();
        int newNumber = tweet.user.getTweetNumbers() + 1;
        tweet.setNumber(newNumber);
        tweet.setRetweeters(new LinkedList<>());
        tweet.setLikers(new LinkedList<>());
        tweet.setMentions(new LinkedList<>());
        FileWriter f = new FileWriter("./src/main/resources/Tweets/" + tweet.user.getID() + "Tweets/" + newNumber + ".json");
        gson.toJson(tweet, f);
        f.flush();
        tweet.user.setTweetNumbers(tweet.user.getTweetNumbers() + 1);
        FileWriter ff = new FileWriter("./src/main/resources/Users/" + tweet.user.getID() + ".json");
        gson.toJson(tweet.user, ff);
        ff.flush();
        File file = new File("./src/main/resources/Comments/" + tweet.getUser().getID() + tweet.getNumber() + "Comments/");
        file.mkdirs();
    }

    @Override
    public int compareTo(Tweet o) {
        return this.getTime().compareTo(o.getTime());
    }
}
