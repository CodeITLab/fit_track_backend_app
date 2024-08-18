package codeit.lab.fit.track.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String notificationTitle;

    @Column(length = 2048)
    private String notificationBody;

    @Column
    private String notificationCategory;

    @Column
    private boolean isNotificationSeen;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Notifications() {}

    public Notifications(long id, String notificationTitle, String notificationBody, String notificationCategory, boolean isNotificationSeen, User user) {
        this.id = id;
        this.notificationTitle = notificationTitle;
        this.notificationBody = notificationBody;
        this.notificationCategory = notificationCategory;
        this.isNotificationSeen = isNotificationSeen;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String title) {
        this.notificationTitle = title;
    }

    public String getNotificationBody() {
        return notificationBody;
    }

    public void setNotificationBody(String body) {
        this.notificationBody = body;
    }

    public String getNotificationCategory() {
        return notificationCategory;
    }

    public void setNotificationCategory(String flag) {
        this.notificationCategory = flag;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean getNotificationSeen() {
        return isNotificationSeen;
    }

    public void setNotificationSeen(boolean notificationSeen) {
        isNotificationSeen = notificationSeen;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", notificationTitle='" + notificationTitle + '\'' +
                ", notificationBody='" + notificationBody + '\'' +
                ", notificationCategory='" + notificationCategory + '\'' +
                ", isNotificationSeen=" + isNotificationSeen +
                ", user=" + user +
                '}';
    }
}
