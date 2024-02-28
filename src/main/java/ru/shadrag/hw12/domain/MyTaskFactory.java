package ru.shadrag.hw12.domain;

import ru.shadrag.hw12.components.Priority;
import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

public class MyTaskFactory implements TaskFactory {
    private final TaskBuilder builder = new TaskBuilder();


    @Override
    public Task createRegularTask(Task task) {
        return builder
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(Priority.REGULAR_PRIORITY)
                .user(task.getUser()).build();
    }

    @Override
    public Task createUrgentTask(Task task) {
        return builder
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(Priority.HIGH_PRIORITY)
                .user(task.getUser()).build();
    }

    @Override
    public Task udateTask(Long id, Task task, User user) {
        return builder.id(id)
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .user(user).build();
    }
}
