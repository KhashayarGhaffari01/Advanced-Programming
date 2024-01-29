package responses;


public class NewTweetResponse extends Response {
    private final String authToken;

    public NewTweetResponse(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.newTweet(authToken);
    }
}
