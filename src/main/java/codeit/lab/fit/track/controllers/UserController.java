package codeit.lab.fit.track.controllers;

import codeit.lab.fit.track.models.Notifications;
import codeit.lab.fit.track.models.User;
import codeit.lab.fit.track.services.NotificationsService;
import codeit.lab.fit.track.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> allUsers = userService.findAllUsers();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-user-data")
    public ResponseEntity<User> getUserData(@RequestParam Long id) {
        try {
            User users = userService.findAll(id);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-users-by-name")
    public ResponseEntity<List<User>> getUsersByNamePattern(@RequestParam String namePattern) {
        try {
            List<User> getListOfUsers = userService.findUsersByNamePattern(namePattern);
            return new ResponseEntity<>(getListOfUsers, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-user-by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        try {
            User userByEmail = userService.findUserByEmail(email);
            return new ResponseEntity<>(userByEmail, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("save-user-data")
    public ResponseEntity<Long> saveUserData(@RequestBody User user) {
        System.out.println(user);
        return userService.saveUser(user);
    }

}
