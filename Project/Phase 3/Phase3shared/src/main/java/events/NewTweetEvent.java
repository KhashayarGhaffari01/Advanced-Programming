package events;

import responses.Response;

public class NewTweetEvent extends Event {
    private final String content, authToken;

    public NewTweetEvent(String content, String authToken) {
        this.content = content;
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.newTweet(content, authToken);
    }
}
