package database;

import model.User;
import util.Token;

public class TokenManager extends BaseManager<Token, String> {
    private static TokenManager tokenManager;

    public static TokenManager getInstance() {
        if (tokenManager == null) {
            tokenManager = new TokenManager();
        }
        return tokenManager;
    }

    @Override
    protected Class<Token> getEntityClass() {
        return Token.class;
    }
}
