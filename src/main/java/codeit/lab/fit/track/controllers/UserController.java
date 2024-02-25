package codeit.lab.fit.track.controllers;

import codeit.lab.fit.track.models.User;
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

    @GetMapping("get-user-data")
    public ResponseEntity<User> getUserData(@RequestParam Long id) {
        try {
            User users = userService.findAll(id);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("save-user-data")
    public ResponseEntity<Long> saveUserData(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
