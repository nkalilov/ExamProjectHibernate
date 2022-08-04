package org.example.dao.impl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public Lesson saveLesson(Lesson lesson) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction();
            session.save(lesson);
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson1 = session.get(Lesson.class,id);
            lesson1.setId(id);
            lesson1.setLessonName(lesson.getLessonName());
            lesson1.setVideoLink(lesson.getVideoLink());
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}

    @Override
    public Lesson getLessonById(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, id);
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Lesson> lessons = session.createQuery("select i from Course c inner join c.lessons l where l.id = :id").getResultList();
            session.getTransaction().commit();
            session.close();
            return lessons;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
