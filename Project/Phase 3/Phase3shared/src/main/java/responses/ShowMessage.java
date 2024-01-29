package responses;

public class ShowMessage extends Response {
    private String message;

    public ShowMessage(String message) {
        this.message = message;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.showMessage(message);
    }
}
