package org.example.service;

import org.example.dao.CourseDao;
import org.example.dao.impl.CourseDaoImpl;
import org.example.entity.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public Course saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourseById(Long id) {
    courseDao.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String courseName) {
        return courseDao.getCourseByName(courseName);
    }
}
