package events;

import responses.Response;

public abstract class Event {
    public abstract Response visit(EventVisitor eventVisitor);

}
