package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.Workout;
import codeit.lab.fit.track.repositories.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public List<Workout> findUsersWorkout(String email) {
        return workoutRepository.findByWorkoutOwner(email);
    }

    public ResponseEntity<String> saveWorkout(Workout workout) {
        workoutRepository.save(workout);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateWorkout(Long id, Workout workout) {
        Workout updatedWorkout = workoutRepository.findById(id).orElseThrow();

        updatedWorkout.setName(workout.getName());
        updatedWorkout.setWorkoutOwner(workout.getWorkoutOwner());
        updatedWorkout.setExercisesData(workout.getExercisesData());

        workoutRepository.save(updatedWorkout);

        return new ResponseEntity<>("Workout created. ", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> deleteWorkout(Long id) {
        workoutRepository.deleteWorkoutById(id);
        return new ResponseEntity<>("Workout Deleted", HttpStatus.OK);
    }
}
