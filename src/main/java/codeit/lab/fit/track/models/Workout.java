package codeit.lab.fit.track.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

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

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "workout_id")
    private List<Exercises> exercisesData = new ArrayList<Exercises>();

    public Workout(long id, String name, List<Exercises> exercisesData) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exercisesList=" + exercisesData +
                '}';
    }
}
