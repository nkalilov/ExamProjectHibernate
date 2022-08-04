package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Task;

import java.util.List;

public interface InstructorDao {

    Instructor saveInstructor(Instructor instructor);

    Instructor updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorsByCourseId(Long id);

    void deleteInstructorById(Long id);

    String assignInstructorToCourse(Long instructorId, Long courseId);
}
