package codeit.lab.fit.track.controllers;

import codeit.lab.fit.track.services.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PutMapping("update-notification")
    public ResponseEntity<String> updateHasNotificationBeenSeen(@RequestParam Long id) {
        return notificationsService.markNotificationAsSeen(id);
    }
}
