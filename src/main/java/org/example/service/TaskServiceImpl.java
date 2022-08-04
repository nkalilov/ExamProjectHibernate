package org.example.service;

import org.example.dao.TaskDao;
import org.example.dao.impl.TaskDaoImpl;
import org.example.entity.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    TaskDao taskDao = new TaskDaoImpl();

    @Override
    public Task saveTask(Task task) {
        return taskDao.saveTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskDao.updateTask(id, task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskDao.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);
    }
}
