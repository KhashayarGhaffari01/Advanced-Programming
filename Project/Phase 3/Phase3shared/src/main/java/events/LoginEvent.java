package events;

import responses.Response;

public class LoginEvent extends Event {
    private final String username, password;

    public LoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.login(username, password);
    }
}
