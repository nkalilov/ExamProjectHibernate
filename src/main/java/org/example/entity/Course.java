package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate created;
    private String imageLink;
    private String description;



    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "courses_instructors",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Lesson> lessons;

    public Course(String courseName, int duration, LocalDate created, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.created = created;
        this.imageLink = imageLink;
        this.description = description;
    }

    public void addInstructorToCourse(Instructor instructor){
        if(instructors == null){
            instructors = new ArrayList<>();
        }
        instructors.add(instructor);
    }
}
