package org.example.service;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor saveInstructor(Instructor instructor);

    Instructor updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorsByCourseId(Long id);

    void deleteInstructorById(Long id);

    String assignInstructorToCourse(Long instructorId, Long courseId);
}
