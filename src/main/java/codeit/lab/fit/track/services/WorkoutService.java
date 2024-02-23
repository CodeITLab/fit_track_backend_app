package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.User;
import codeit.lab.fit.track.models.Workout;
import codeit.lab.fit.track.repositories.UserRepository;
import codeit.lab.fit.track.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
}
