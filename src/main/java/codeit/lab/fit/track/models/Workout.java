package codeit.lab.fit.track.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private Long workoutOwner;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workout_id")
    private List<Exercises> exercisesData = new ArrayList<Exercises>();

    public Workout(long id, String name, Long workoutOwner, List<Exercises> exercisesData) {
        this.id = id;
        this.name = name;
        this.workoutOwner = workoutOwner;
        this.exercisesData = exercisesData;
    }

    public Workout() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String workoutName) {
        this.name = workoutName;
    }

    public List<Exercises> getExercisesData() {
        return exercisesData;
    }

    public void setExercisesData(List<Exercises> exercisesList) {
        this.exercisesData = exercisesList;
    }

    public Long getWorkoutOwner() {
        return workoutOwner;
    }

    public void setWorkoutOwner(Long workoutOwner) {
        this.workoutOwner = workoutOwner;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workoutOwner='" + workoutOwner + '\'' +
                ", exercisesData=" + exercisesData +
                '}';
    }
}
