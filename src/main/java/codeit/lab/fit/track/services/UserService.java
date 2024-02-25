package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.User;
import codeit.lab.fit.track.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findAll(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public ResponseEntity<Long> saveUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }
}
