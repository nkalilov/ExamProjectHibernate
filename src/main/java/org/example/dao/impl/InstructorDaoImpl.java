package org.example.dao.impl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    public Instructor saveInstructor(Instructor instructor) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction();
            session.save(instructor);
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor1 = session.get(Instructor.class,id);
            instructor1.setId(instructor.getId());
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            session.getTransaction().commit();
            session.close();
            return instructor1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor= session.get(Instructor.class, id);
            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
//            List<Instructor> instructors = session.createQuery("select i from Course c inner join c.instructors i where i.id = :id").getResultList();
            Course course1 = session.get(Course.class, id);
            List<Instructor> instructors1 = course1.getInstructors();
            session.close();
            return instructors1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteInstructorById(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Instructor i where i.id =:id");
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor= session.get(Instructor.class, instructorId);
            Course course= session.get(Course.class, courseId);
            course.addInstructorToCourse(instructor);
            session.getTransaction().commit();
            session.close();
            return "Successfully assigned";
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
