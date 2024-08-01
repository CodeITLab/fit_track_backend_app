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
    private String notificationsTitle;

    @Column(length = 2048)
    private String notificationsDescriptions;

    @Column
    private String notificationsCategory;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Notifications() {}

    public Notifications(long id, String notificationsTitle, String notificationsDescriptions, String notificationsCategory, User user) {
        this.id = id;
        this.notificationsTitle = notificationsTitle;
        this.notificationsDescriptions = notificationsDescriptions;
        this.notificationsCategory = notificationsCategory;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotificationsTitle() {
        return notificationsTitle;
    }

    public void setNotificationsTitle(String title) {
        this.notificationsTitle = title;
    }

    public String getNotificationsDescriptions() {
        return notificationsDescriptions;
    }

    public void setNotificationsDescriptions(String body) {
        this.notificationsDescriptions = body;
    }

    public String getNotificationsCategory() {
        return notificationsCategory;
    }

    public void setNotificationsCategory(String flag) {
        this.notificationsCategory = flag;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", title='" + notificationsTitle + '\'' +
                ", body='" + notificationsDescriptions + '\'' +
                ", flag='" + notificationsCategory + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
