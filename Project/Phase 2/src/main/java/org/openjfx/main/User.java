package org.openjfx.main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class User {

    private String ID;

    public User(String ID) {
        this.ID = ID;
    }

    private String Password;
    private String FirstName;
    private String LastName;
    private Date Birthday;
    private String Email;
    private String PhoneNumber;
    private String Biography;
    private int TweetNumbers;
    private List<String> Followers;
    private List<String> Followings;
    private List<String> Blocks;
    private java.time.LocalDateTime LastOnline;
    private boolean Public;
    private List<String> Requests;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public int getTweetNumbers() {
        return TweetNumbers;
    }

    public void setTweetNumbers(int tweetNumbers) {
        TweetNumbers = tweetNumbers;
    }

    public LocalDateTime getLastOnline() {
        return LastOnline;
    }

    public void setLastOnline(LocalDateTime lastOnline) {
        LastOnline = lastOnline;
    }

    public boolean isPublic() {
        return Public;
    }

    public void setPublic(boolean aPublic) {
        Public = aPublic;
    }

    public List<String> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<String> followers) {
        Followers = followers;
    }

    public List<String> getFollowings() {
        return Followings;
    }

    public void setFollowings(List<String> followings) {
        Followings = followings;
    }

    public List<String> getBlocks() {
        return Blocks;
    }

    public void setBlocks(List<String> blocks) {
        Blocks = blocks;
    }

    public List<String> getRequests() {
        return Requests;
    }

    public void setRequests(List<String> requests) {
        Requests = requests;
    }

    public static java.time.LocalDateTime LastOnline (User user1, User user2){
        // ...
        return user1.getLastOnline();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}








