package database;

import model.Tweet;

public class TweetManager extends BaseManager<Tweet, Integer> {
    private static TweetManager tweetManager;

    public static TweetManager getInstance() {
        if (tweetManager == null) {
            tweetManager = new TweetManager();
        }
        return tweetManager;
    }

    @Override
    protected Class<Tweet> getEntityClass() {
        return Tweet.class;
    }
}
