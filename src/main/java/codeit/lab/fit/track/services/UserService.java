package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.User;
import codeit.lab.fit.track.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findAll(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    public List<User> findUsersByNamePattern(String namePattern) {
        return userRepository.findByNameContainsIgnoreCase(namePattern);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public ResponseEntity<Long> saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            User loggedInUser = userRepository.findByEmail(user.getEmail());
            return new ResponseEntity<>(loggedInUser.getId(), HttpStatus.OK);
        } else {
            userRepository.save(user);
            return new ResponseEntity<>(user.getId(), HttpStatus.OK);
        }
    }
}
