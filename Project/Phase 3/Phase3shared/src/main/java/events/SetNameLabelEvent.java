package events;

import responses.Response;

public class SetNameLabelEvent extends Event {
    private final String authToken;

    public SetNameLabelEvent(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.setNameLabel(authToken);
    }
}
