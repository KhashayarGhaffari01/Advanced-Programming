package responses;

public class SetNameLabelResponse extends Response {
    private final String authToken, name;

    public SetNameLabelResponse(String authToken, String name) {
        this.authToken = authToken;
        this.name = name;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.setNameLabel(authToken, name);
    }
}
