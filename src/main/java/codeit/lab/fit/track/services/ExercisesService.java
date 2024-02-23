package codeit.lab.fit.track.services;

import codeit.lab.fit.track.models.Exercises;
import codeit.lab.fit.track.models.User;
import codeit.lab.fit.track.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercises> findAll() {
        return exerciseRepository.findAll();
    }

    public Exercises saveExercises(Exercises exercises) {
        return exerciseRepository.save(exercises);
    }
}
