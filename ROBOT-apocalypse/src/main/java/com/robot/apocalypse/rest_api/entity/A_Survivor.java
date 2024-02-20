package com.robot.apocalypse.rest_api.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 *  Marks the class as a JPA entity,
 *  indicating that it should be persisted to the database.
 *  Each instance of this class corresponds to a row in the database table.
 */
@Entity
/*
  Specifies the name of the database table associated with this entity.
  In this case, the table is named "survivors".
 */
@Table(name = "survivor") // Specify the table name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class A_Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    /**
     *  Specifies the mapping of the annotated field to the corresponding column in the database table.
     *  Counter representing the number of reported infections for the survivor.
     */
    @Column(nullable = false)
    private int infectionCounter;

     /**
     *  Specifies the mapping of the annotated field to the corresponding column in the database table.
     *  Status indicating whether the survivor is infected.
     */
    @Column(nullable = false)
    private boolean infectionStatus;


     /**
     // Using @Embedded to indicate that SurvivorResource will be embedded in Survivor
      */
    @Embedded
    private SurvivorResource inventory;
}
