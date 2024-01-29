package org.openjfx.Pages;

import com.google.gson.Gson;
import org.openjfx.main.*;

import java.io.*;
import java.util.*;

public class Timeline {
    public static List<Tweet> userTweets(User user) throws FileNotFoundException {
        List<Tweet> res = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 1; i <= user.getTweetNumbers(); i++) {
            res.add(gson.fromJson(new FileReader("./src/main/resources/Tweets/" + user.getID() + "Tweets/" + i + ".json"), Tweet.class));
        }
        return res;
    }

    public static List<Tweet> allTweets(User user) throws FileNotFoundException {
        List<Tweet> userFollowingTweets = new LinkedList<>();
        for (String user2id : user.getFollowings()) {
            userFollowingTweets.addAll(userTweets(Methods.getUserFromID(user2id)));
        }
        userFollowingTweets.sort(Comparator.reverseOrder());
        return userFollowingTweets;
    }

    static void showTweet(User user, int number) throws FileNotFoundException {
        System.out.println(Color.YELLOW_BOLD + allTweets(user).get(number).getUser().getID());
        System.out.println(Color.BLUE + allTweets(user).get(number).getContent());
        System.out.println(Color.GREEN_BACKGROUND + Color.BLACK_BOLD + allTweets(user).get(number).getRetweeters().size() + Color.GREEN + " Retweets" + "   " + Color.RED_BACKGROUND + Color.BLACK_BOLD + allTweets(user).get(number).getLikers().size() + Color.RED + " Likes" + Color.RESET);
        System.out.println();
    }

    static void allComments(Tweet tweet) {

    }

    static void openTweet(Tweet tweet, User user, int number) throws IOException {
        System.out.println(Color.YELLOW_BOLD + tweet.getUser().getID());
        System.out.println(Color.BLUE + tweet.getContent());
        System.out.println(Color.GREEN_BACKGROUND + Color.BLACK_BOLD + tweet.getRetweeters().size() + Color.GREEN + " Retweets" + "   " + Color.RED_BACKGROUND + Color.BLACK_BOLD + tweet.getLikers().size() + Color.RED + " Likes" + Color.RESET);
        System.out.println();
        System.out.println("1-Open");
        System.out.println("0-Add Comment");
        if (tweet.getMentions().get(number).getLikers().contains(user)) {
            System.out.println("2-UnLike");
        } else {
            System.out.println("2-Like");
        }
        if (tweet.getMentions().get(number).getRetweeters().contains(user)) {
            System.out.println("3-UnRetweet");
        } else {
            System.out.println("3-Retweet");
        }
        System.out.println("4-Next");
        System.out.println("5-Previous");
        System.out.println("6-Forward to ...");
        System.out.println("7-Report writer.");
        System.out.println("8-Add to Saved Messages.");
        if (user.getBlocks().contains(tweet.getMentions().get(number).getUser().getID())) {
            System.out.println("9-Unblock");
        } else {
            System.out.println("9-Block");
        }
        System.out.println("10-Main Menu");
        if (tweet.getMentions().size() == 0) {
            System.out.println("No Tweets for show :(");
            MainMenu.run(user);
        } else {
            System.out.println(tweet.getMentions().get(number).getUser().getID());
            System.out.println(tweet.getMentions().get(number).getContent());
            System.out.println(Color.GREEN_BACKGROUND + Color.BLACK_BOLD + tweet.getMentions().get(number).getRetweeters().size() + Color.GREEN + " Retweets" + "   " + Color.RED_BACKGROUND + Color.BLACK_BOLD + tweet.getMentions().get(number).getLikers().size() + Color.RED + " Likes" + Color.RESET);
            System.out.println();
            Scanner sc = new Scanner(System.in);
            String Ans = sc.next();
            if (Ans.equals("1")) {
                openTweet(tweet.getMentions().get(number), user, 0);
            }
            if (Ans.equals("0")) {
                System.out.println("Type your Comment.");
                String chert = sc.nextLine();
                String content = sc.nextLine();
                Comment.newCommentForTweet(new Comment(user, content, tweet.getMentions().get(number)));
            }
            if (Ans.equals("2")) {
                if (tweet.getMentions().get(number).getLikers().contains(user)) {
                    Action.unlike(user, tweet.getMentions().get(number));
                } else {
                    Action.like(user, tweet.getMentions().get(number));
                }
                openTweet(tweet, user, number);
            }
            if (Ans.equals("3")) {
                if (tweet.getMentions().get(number).getRetweeters().contains(user)) {

                } else {
                    Action.retweet(user, tweet.getMentions().get(number));
                }
                openTweet(tweet, user, number);
            }
            if (Ans.equals("4")) {
                if (number + 1 < tweet.getMentions().size()) {
                    openTweet(tweet, user, number + 1);
                } else {
                    System.out.println("Finish!");
                    openTweet(tweet, user, number);
                }
            }
            if (Ans.equals("5")) {
                if (number > 0) {
                    openTweet(tweet, user, number - 1);
                } else {
                    System.out.println("This is first!");
                    openTweet(tweet, user, number);
                }
            }
            if (Ans.equals("6")) {

            }
            if (Ans.equals("7")) {
                System.out.println("Reported.");
                run(user, number);
            }
            if (Ans.equals("8")) {

            }
            if (Ans.equals("9")) {
                if (user.getBlocks().contains(tweet.getMentions().get(number).getUser().getID())) {
                    Action.unblock(user, tweet.getMentions().get(number).getUser());
                } else {
                    Action.block(user, tweet.getMentions().get(number).getUser());
                }
                run(user, number);
            }
            if (Ans.equals("10")) {
                MainMenu.run(user);
            }
            if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5") && !Ans.equals("6") && !Ans.equals("7") && !Ans.equals("8") && !Ans.equals("9") && !Ans.equals("10")) {
                System.out.println("Invalid Request!");
                run(user, number);
            }

        }
    }

    static void run(User user, int number) throws IOException {
        if (allTweets(user).size() == 0) {
            System.out.println("No Tweets for show :(");
            MainMenu.run(user);
        } else {
            System.out.println("1-Open");
            System.out.println("0-Add Comment");
            if (allTweets(user).get(number).getLikers().contains(user)) {
                System.out.println("2-UnLike");
            } else {
                System.out.println("2-Like");
            }
            if (allTweets(user).get(number).getRetweeters().contains(user)) {
                System.out.println("3-UnRetweet");
            } else {
                System.out.println("3-Retweet");
            }
            System.out.println("4-Next");
            System.out.println("5-Previous");
            System.out.println("6-Forward to ...");
            System.out.println("7-Report writer.");
            System.out.println("8-Add to Saved Messages.");
            if (user.getBlocks().contains(allTweets(user).get(number).getUser().getID())) {
                System.out.println("9-Unblock");
            } else {
                System.out.println("9-Block");
            }
            System.out.println("10-Main Menu");
            showTweet(user, number);

            Scanner sc = new Scanner(System.in);
            String Ans = sc.next();
            if (Ans.equals("1")) {
                openTweet(allTweets(user).get(number), user, 0);
            }
            if (Ans.equals("0")) {
                System.out.println("Type your Comment.");
                String chert = sc.nextLine();
                String content = sc.nextLine();
                Comment.newCommentForTweet(new Comment(user, content, allTweets(user).get(number)));
                run(user, number);
            }
            if (Ans.equals("2")) {
                if (allTweets(user).get(number).getLikers().contains(user)) {
                    Action.unlike(user, allTweets(user).get(number));
                } else {
                    Action.like(user, allTweets(user).get(number));
                }
                run(user, number);
            }
            if (Ans.equals("3")) {
                if (allTweets(user).get(number).getRetweeters().contains(user)) {

                } else {
                    Action.retweet(user, allTweets(user).get(number));
                }
                run(user, number);
            }
            if (Ans.equals("4")) {
                if (number + 1 < allTweets(user).size()) {
                    run(user, number + 1);
                } else {
                    System.out.println("Finish!");
                    run(user, number);
                }
            }
            if (Ans.equals("5")) {
                if (number > 0) {
                    run(user, number - 1);
                } else {
                    System.out.println("This is first!");
                    run(user, number);
                }
            }
            if (Ans.equals("6")) {

            }
            if (Ans.equals("7")) {
                System.out.println("Reported.");
                run(user, number);
            }
            if (Ans.equals("8")) {

            }
            if (Ans.equals("9")) {
                if (user.getBlocks().contains(allTweets(user).get(number).getUser().getID())) {
                    Action.unblock(user, allTweets(user).get(number).getUser());
                } else {
                    Action.block(user, allTweets(user).get(number).getUser());
                }
                run(user, number);
            }
            if (Ans.equals("10")) {
                MainMenu.run(user);
            }
            if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5") && !Ans.equals("6") && !Ans.equals("7") && !Ans.equals("8") && !Ans.equals("9") && !Ans.equals("10")) {
                System.out.println("Invalid Request!");
                run(user, number);
            }
        }

    }
}

