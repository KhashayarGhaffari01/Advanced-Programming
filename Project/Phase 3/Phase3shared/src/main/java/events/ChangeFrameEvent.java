package events;

import responses.Response;

public class ChangeFrameEvent extends Event {
    private final String frame;

    public ChangeFrameEvent(String frame) {
        this.frame = frame;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.changeFrame(frame);
    }
}
