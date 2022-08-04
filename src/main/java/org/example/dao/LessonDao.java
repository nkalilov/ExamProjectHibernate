package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Lesson;

import java.util.List;

public interface LessonDao {

    Lesson saveLesson(Lesson lesson);

    Lesson updateLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourseId(Long id);


}
