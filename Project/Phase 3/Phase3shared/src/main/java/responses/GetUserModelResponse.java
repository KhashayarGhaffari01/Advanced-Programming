package responses;

import model.UserModel;

public class GetUserModelResponse extends Response {
    private final String authToken;
    private final UserModel userModel;

    public GetUserModelResponse(String authToken, UserModel userModel) {
        this.authToken = authToken;
        this.userModel = userModel;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.getUserModel(authToken, userModel);
    }
}
