package ru.shadrag.hw12.domain;

import ru.shadrag.hw12.components.Priority;
import ru.shadrag.hw12.components.Status;
import ru.shadrag.hw12.models.Task;
import ru.shadrag.hw12.models.User;

public class TaskBuilder {
    private final Task task = new Task();

    public TaskBuilder id(Long id) {
        task.setId(id);
        return this;
    }

    public TaskBuilder title(String title) {
        task.setTitle(title);
        return this;
    }

    public TaskBuilder description(String description) {
        task.setDescription(description);
        return this;
    }

    public TaskBuilder status(Status status) {
        task.setStatus(status);
        return this;
    }


    public TaskBuilder priority(Priority priority) {
        task.setPriority(priority);
        return this;
    }

    public TaskBuilder user(User user) {
        task.setUser(user);
        return this;
    }

    public Task build() {
        return task;
    }

}
