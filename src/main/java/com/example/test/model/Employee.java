package com.example.test.model;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private long id ;

    @Column(name="first_name")
    private String fristName ;

    @Column(name="last_name")
    private String lastName ;

    @Column(name="email")
    private String email;

    public Employee() {
        super();

    }

    public Employee(String fristName, String lastName, String email) {
        super();
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
