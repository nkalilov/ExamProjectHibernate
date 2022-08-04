package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    Course updateCourse(Long id, Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);
}
