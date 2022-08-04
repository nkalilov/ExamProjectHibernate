package org.example.dao.impl;

import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDaoImpl implements CourseDao {

    @Override
    public Course saveCourse(Course course) {
      try {
          SessionFactory sessionFactory = Config.getSessionFactory();
          Session session = sessionFactory.openSession();
          session.getTransaction();
          session.save(course);
          System.out.println("Course with name " + course.getCourseName() + " successfully saved to db");
          session.close();
      } catch (Exception e){
          e.printStackTrace();
      }
        return null;
    }

    @Override
    public Course getCourseById(Long id) {
    try {
        SessionFactory sessionFactory = Config.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.getTransaction().commit();
        session.close();
        return course;
    } catch (Exception e){
        e.printStackTrace();
    }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courseList = session.createQuery("from Course ").getResultList();
            List<Course> courses = courseList.stream().sorted(Comparator.comparing(Course::getCreated)).collect(Collectors.toList());
            session.close();
            return courses;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course2 = session.get(Course.class, id);
            course2.setId(course.getId());
            course2.setCourseName(course.getCourseName());
            course2.setDescription(course.getDescription());
            course2.setCreated(course.getCreated());
            course2.setDuration(course.getDuration());
            course2.setImageLink(course.getImageLink());
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Course c where c.id =:id");
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourseByName(String courseName){
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, courseName);
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
