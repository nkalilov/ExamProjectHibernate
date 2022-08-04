package org.example.service;

import org.example.entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson saveLesson(Lesson lesson);

    Lesson updateLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourseId(Long id);
}
