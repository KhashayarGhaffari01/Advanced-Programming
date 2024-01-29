package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.boot.model.relational.QualifiedTableName;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Khwitter")
public class User implements Serializable {

    @Id
    private String ID;

    public User(String ID) {
        this.ID = ID;
    }

    public User() {
    }

    @Column
    private String Password;
    @Column
    private String FirstName = "";
    @Column
    private String LastName = "";
    @ManyToOne
    @Cascade({CascadeType.DELETE, CascadeType.PERSIST})
    private Date Birthday;
    @Column
    private String Email = "";
    @Column
    private String PhoneNumber = "";
    @Column
    private String Biography = "";
    @Column
    private int TweetNumbers = 0;
    @ManyToMany()
    @Cascade({CascadeType.PERSIST})
    private List<User> Followers = new LinkedList<>();
    @ManyToMany(mappedBy = "Followers")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<User> Followings = new LinkedList<>();
    @ManyToMany
    @Cascade(CascadeType.PERSIST)
    private List<User> Blocks = new LinkedList<>();
//    @Column
    private LocalDateTime LastOnline;
    @Column
    private boolean Public = true;
    @Column
    private boolean isOnline = false;
    @ManyToMany
    @Cascade(CascadeType.PERSIST)
    private List<User> Requests = new LinkedList<>();


    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public List<User> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<User> followers) {
        Followers = followers;
    }

    public List<User> getFollowings() {
        return Followings;
    }

    public void setFollowings(List<User> followings) {
        Followings = followings;
    }

    public List<User> getBlocks() {
        return Blocks;
    }

    public void setBlocks(List<User> blocks) {
        Blocks = blocks;
    }

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

    public List<User> getRequests() {
        return Requests;
    }

    public void setRequests(List<User> requests) {
        Requests = requests;
    }

    public static LocalDateTime LastOnline(User user1, User user2) {
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








