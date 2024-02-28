package ru.shadrag.hw12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shadrag.hw12.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
