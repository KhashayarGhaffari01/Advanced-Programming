package main;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Action {
    public static void follow(User user2, User user1) throws IOException {
        List<String> Follower1 = user1.getFollowers();
        Follower1.add(user2.getID());
        user1.setFollowers(Follower1);
        List<String> Following2 = user2.getFollowings();
        Following2.add(user1.getID());
        user2.setFollowings(Following2);
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
    public static void unfollow(User user2, User user1) throws IOException {
        List<String> Follower1 = user1.getFollowers();
        Follower1.remove(user2.getID());
        user1.setFollowers(Follower1);
        List<String> Following2 = user2.getFollowings();
        Following2.remove(user1.getID());
        user2.setFollowings(Following2);
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
    public static void block(User user2, User user1) throws IOException {
        List<String> Blocks = user2.getBlocks();
        Blocks.add(user1.getID());
        user2.setBlocks(Blocks);
        if (user2.getFollowers().contains(user1)){
            List<String> Follower2 = user2.getFollowers();
            Follower2.remove(user1.getID());
            user2.setFollowers(Follower2);
        }
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f);
        f.flush();
    }
    public static void unblock(User user2, User user1) throws IOException {
        List<String> Blocks = user2.getBlocks();
        Blocks.remove(user1.getID());
        user2.setBlocks(Blocks);
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f);
        f.flush();
    }
    public static void followRequest(User user2, User user1) throws IOException {
        List<String> Follower1 = user1.getRequests();
        Follower1.add(user2.getID());
        user1.setRequests(Follower1);
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
    public static void unfollowRequest(User user2, User user1) throws IOException {
        List<String> Follower1 = user1.getRequests();
        Follower1.remove(user2.getID());
        user1.setFollowers(Follower1);
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
    public static void like(User user, Tweet tweet) throws IOException {
        List<User> tweetLikers = tweet.getLikers();
        tweetLikers.add(user);
        tweet.setLikers(tweetLikers);
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Tweets/" + tweet.user.getID() + "Tweets/" + tweet.getNumber() + ".json");
        gson.toJson(tweet, f);
        f.flush();
    }
    public static void unlike(User user, Tweet tweet) throws IOException {
        List<User> tweetLikers = tweet.getLikers();
        tweetLikers.remove(user);
        tweet.setLikers(tweetLikers);
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Tweets/" + tweet.user.getID() + "Tweets/" + tweet.getNumber() + ".json");
        gson.toJson(tweet, f);
        f.flush();
    }
    public static void retweet(User user, Tweet tweet) throws IOException {
        List<User> tweetRewtweeters = tweet.getRetweeters();
        tweetRewtweeters.add(user);
        tweet.setRetweeters(tweetRewtweeters);
        Tweet.newTweet(new Tweet(user, "(Retweeted from " + tweet.getUser().getID() + ") " + tweet.content));
        Gson gson = new Gson();
        FileWriter f = new FileWriter("./src/main/resources/Tweets/" + tweet.user.getID() + "Tweets/" + tweet.getNumber() + ".json");
        gson.toJson(tweet, f);
        f.flush();
    }
    public static void acceptRequest(User user1, User user2) throws IOException {
        List<String> user1Requests = user1.getRequests();
        List<String> user1Followers = user1.getFollowers();
        List<String> user2Followings = user2.getFollowings();
        user1Requests.remove(user2.getID());
        user1Followers.add(user2.getID());
        user2Followings.add(user1.getID());
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
    public static void denyRequest(User user1, User user2) throws IOException {
        List<String> user1Requests = user1.getRequests();
        user1Requests.remove(user2.getID());
        Gson gson = new Gson();
        FileWriter f1 = new FileWriter("./src/main/resources/Users/" + user1.getID() + ".json");
        gson.toJson(user1, f1);
        FileWriter f2 = new FileWriter("./src/main/resources/Users/" + user2.getID() + ".json");
        gson.toJson(user2, f2);
        f1.flush();
        f2.flush();
    }
}
