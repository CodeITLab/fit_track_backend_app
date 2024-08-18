package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.Notifications;
import codeit.lab.fit.track.repositories.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notifications> findAllNotifications() { return notificationRepository.findAll(); }

    public Notifications saveNotification(Notifications notifications) { return notificationRepository.save(notifications); }

    @Transactional
    public ResponseEntity<String> markNotificationAsSeen(long id) {
        notificationRepository.updateNotificationSeenStatus(id, true);
        return new ResponseEntity<>("Notification - isNotificationSeen atribute updated.", HttpStatus.OK);
    }
}
