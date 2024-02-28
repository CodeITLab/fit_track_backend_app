package codeit.lab.fit.track.controllers;

import codeit.lab.fit.track.models.Workout;
import codeit.lab.fit.track.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("get-workout-data")
    public ResponseEntity<List<Workout>> getWorkoutData() {
        try {
            List<Workout> workouts = workoutService.findAll();
            return new ResponseEntity<>(workouts, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get-users-workouts")
    public ResponseEntity<List<Workout>> getWorkoutForLoggedInUser(@RequestParam Long id) {
        try {
            List<Workout> usersWorkouts = workoutService.findUsersWorkout(id);
            return new ResponseEntity<>(usersWorkouts, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("save-workout-data")
    public ResponseEntity<String> saveWorkoutData(@RequestBody Workout workout) {
        return workoutService.saveWorkout(workout);
    }
}
