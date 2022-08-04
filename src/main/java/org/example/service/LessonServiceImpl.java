package org.example.service;

import org.example.dao.LessonDao;
import org.example.dao.impl.LessonDaoImpl;
import org.example.entity.Lesson;

import java.util.List;

public class LessonServiceImpl implements LessonService{

    LessonDao lessonDao = new LessonDaoImpl();

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return lessonDao.saveLesson(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return lessonDao.updateLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        return lessonDao.getLessonsByCourseId(id);
    }
}
