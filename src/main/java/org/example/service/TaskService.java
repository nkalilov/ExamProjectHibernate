package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    Task updateTask(Long id, Task task);

    List<Task> getAllTaskByLessonId(Long id);

    void deleteTaskById(Long id);
}
