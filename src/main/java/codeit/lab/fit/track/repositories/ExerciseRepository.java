package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercises, Long> {
}
