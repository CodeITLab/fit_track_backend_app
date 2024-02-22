package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
