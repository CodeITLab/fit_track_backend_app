package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {

    @Modifying
    @Query("UPDATE Notifications n SET n.isNotificationSeen = :isSeen WHERE n.id = :id")
    void updateNotificationSeenStatus(@Param("id") long id, @Param("isSeen") boolean isSeen);
}
