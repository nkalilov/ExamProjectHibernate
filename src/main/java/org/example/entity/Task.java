package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private int deadLine;
    private String task;


    public Task(String taskName, int deadLine, String task) {
        this.taskName = taskName;
        this.deadLine = deadLine;
        this.task = task;
    }
}
