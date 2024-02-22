package codeit.lab.fit.track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "workout_name")
    private String workoutName;

    public Workout() {}

    public Workout(long id, String workoutName) {
        this.id = id;
        this.workoutName = workoutName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", workoutName='" + workoutName + '\'' +
                '}';
    }
}
