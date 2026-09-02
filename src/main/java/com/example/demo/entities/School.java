package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class School {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @OneToMany( cascade = CascadeType.ALL)

    List<Student> students;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

}
