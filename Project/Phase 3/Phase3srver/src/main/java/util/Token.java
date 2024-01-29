package util;

import model.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Token {
    @Id
    private String authToken;
    @OneToOne
    private User user;

    public Token(String authToken) {
        this.authToken = authToken;
        this.user = null;
    }

    public Token() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
