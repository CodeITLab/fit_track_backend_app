package codeit.lab.fit.track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_group")
public class WorkoutGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
