package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.Workout;
import codeit.lab.fit.track.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public ResponseEntity<String> saveWorkout(Workout workout) {
        workoutRepository.save(workout);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
