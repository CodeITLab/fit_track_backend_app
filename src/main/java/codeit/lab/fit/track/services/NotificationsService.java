package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.Notifications;
import codeit.lab.fit.track.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notifications> findAllNotifications() { return notificationRepository.findAll(); }

    public Notifications saveNotification(Notifications notifications) { return notificationRepository.save(notifications); }
}
