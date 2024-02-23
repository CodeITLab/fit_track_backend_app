package codeit.lab.fit.track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sets")
    private Integer sets;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "is_workout_finished")
    private Boolean isWorkoutFinished;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Exercises(long id, String name, Integer sets, Integer reps, Boolean isWorkoutFinished) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.isWorkoutFinished = isWorkoutFinished;
    }

    public Exercises() {

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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Boolean getWorkoutFinished() {
        return isWorkoutFinished;
    }

    public void setWorkoutFinished(Boolean workoutFinished) {
        isWorkoutFinished = workoutFinished;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", isWorkoutFinished=" + isWorkoutFinished +
                ", workout=" + workout +
                '}';
    }
}
