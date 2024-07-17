package codeit.lab.fit.track.controllers;

import codeit.lab.fit.track.models.Workout;
import codeit.lab.fit.track.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Workout>> getWorkoutForLoggedInUser(@RequestParam String email) {
    System.out.println(email);
        try {
            List<Workout> usersWorkouts = workoutService.findUsersWorkout(email);
            return new ResponseEntity<>(usersWorkouts, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("save-workout-data")
    public ResponseEntity<String> saveWorkoutData(@RequestBody Workout workout) {
        System.out.println(workout);
        return workoutService.saveWorkout(workout);
    }

    @PutMapping("update-user-workout")
    public ResponseEntity<String> updateUserWorkout(@RequestParam Long id, @RequestBody Workout workout) {
        System.out.println(workout);
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("delete-user-workout")
    public ResponseEntity<String> deleteUserWorkout(@RequestParam Long id) {
        return workoutService.deleteWorkout(id);
    }
}
