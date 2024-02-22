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

}
