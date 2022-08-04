package org.example;

import org.example.config.Config;
import org.example.dao.impl.CourseDaoImpl;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.service.CourseService;
import org.example.service.CourseServiceImpl;
import org.example.service.InstructorService;
import org.example.service.InstructorServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

//        Config.getSessionFactory();
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LocalDate localDate = LocalDate.of(2022,01,01);
//        Course course = new Course("Java Script", 9, localDate, "link1", "Frontend");
//        courseService.saveCourse(course);
//        Course course = courseService.getCourseById(3L);
//        Instructor instructor = new Instructor("Meerim", "Asanova", "meerim@gamil.com", 777777777);
//        instructorService.saveInstructor(instructor);
//        instructorService.assignInstructorToCourse(instructor.getId(),course.getId());
//        instructorService.getInstructorsByCourseId(3L);
    }
}
