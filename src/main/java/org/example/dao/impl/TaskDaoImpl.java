package org.example.dao.impl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    @Override
    public Task saveTask(Task task) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction();
            session.save(task);
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Task updateTask(Long id, Task task1) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.get(Task.class,id);
            task.setId(task1.getId());
            task.setTaskName(task1.getTaskName());
            task.setDeadLine(task1.getDeadLine());
            task.setTask(task1.getTask());
            session.getTransaction().commit();
            session.close();
            return task;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override //
    public List<Task> getAllTaskByLessonId(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Task> tasks = session.createQuery("select t from Lesson l inner join l.tasks t where l.id = :id").getResultList();
            session.close();
            return tasks;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            SessionFactory sessionFactory = Config.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.get(Task.class, id);
            session.delete(task);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

