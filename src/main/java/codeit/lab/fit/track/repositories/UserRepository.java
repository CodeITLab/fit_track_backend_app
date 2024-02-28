package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContainsIgnoreCase(String namePattern);

    User findByEmail(String email);

}
