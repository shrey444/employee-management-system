package com.shrey.Employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
/*The entities are the persistence objects
 stores as a record in the database.
 for you all wondering what persistance is
 It is a class that contains static methods
 to obtain an EntityManagerFactory instance.
 EntityManagerFactory: It is a factory class
 of EntityManager. It creates and manages
 multiple instances of EntityManager.
 EntityManager: It is an interface.
 */
@Data
@Table(name="Employees")
/*The @Table annotation specifies the name of
the database table to be used for mapping. */
public class EmployeeEntity {

    @Id
    /*The @Id annotation specifies the primary
    key of an entity */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@GeneratedValue provides for the specification
    of generation strategies for the values of primary keys. */
    private long id;

    private String first_name;
    private String last_name;
    private String emailId;

}
