package codeit.lab.fit.track.repositories;

import codeit.lab.fit.track.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByWorkoutOwner(String email);
    Workout deleteWorkoutById(Long id);
    Workout updateWorkoutById(Long id);
}
