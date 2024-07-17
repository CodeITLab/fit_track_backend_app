package codeit.lab.fit.track.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "picture")
    private String picture;

    @Column(name = "is_auth")
    private String isAuth;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Notifications> notifications = new ArrayList<Notifications>();

    public User() {

    }

    public User(long id, String name, String lastName, String email, String picture, String isAuth, String userType, String password, List<Notifications> notifications) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.isAuth = isAuth;
        this.userType = userType;
        this.password = password;
        this.notifications = notifications;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", isAuth='" + isAuth + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                ", notifications: " + notifications + '\'' +
                '}';
    }

}
