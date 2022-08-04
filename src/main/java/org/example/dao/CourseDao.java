package org.example.dao;

import org.example.entity.Course;

import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    Course updateCourse(Long id, Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);


}
