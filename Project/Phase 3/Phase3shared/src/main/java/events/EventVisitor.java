package events;

import responses.Response;

public interface EventVisitor {
    Response changeFrame(String frame);

    Response login(String username, String password);

    Response newTweet(String content, String authToken);

    Response setNameLabel(String authToken);

    Response getUserModel(String authToken);


}
