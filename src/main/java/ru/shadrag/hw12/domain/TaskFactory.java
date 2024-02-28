package ru.shadrag.hw12.domain;

import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

public interface TaskFactory {
    Task createRegularTask(Task task);
    Task createUrgentTask(Task task);
    Task udateTask(Long id, Task task, User user);
}
