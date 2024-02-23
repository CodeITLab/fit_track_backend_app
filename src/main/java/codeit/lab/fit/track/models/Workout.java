package codeit.lab.fit.track.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Exercises> exercisesData;

    public Workout() {}

    public Workout(long id, String name) {
        this.id = id;
        this.name = name;
    }

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
