package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
