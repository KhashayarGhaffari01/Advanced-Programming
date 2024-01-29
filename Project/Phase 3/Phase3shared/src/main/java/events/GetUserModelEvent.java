package events;

import responses.Response;

public class GetUserModelEvent extends Event {
    private final String authToken;

    public GetUserModelEvent(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.getUserModel(authToken);
    }
}
