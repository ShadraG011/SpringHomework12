package ru.shadrag.hw12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shadrag.hw12.models.Task;

public interface TasksRepository extends JpaRepository<Task, Long> {
}
