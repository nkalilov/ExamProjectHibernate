package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter@Setter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    private String videoLink;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Lesson(String lessonName, String videoLink) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;
    }
}
