package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {

}
