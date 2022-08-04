package org.example.service;

import org.example.dao.InstructorDao;
import org.example.dao.impl.InstructorDaoImpl;
import org.example.entity.Instructor;

import java.util.List;

public class InstructorServiceImpl implements InstructorService{

    InstructorDao instructorDao = new InstructorDaoImpl();

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorDao.saveInstructor(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long id) {
        return instructorDao.getInstructorsByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        return instructorDao.assignInstructorToCourse(instructorId, courseId);
    }
}
