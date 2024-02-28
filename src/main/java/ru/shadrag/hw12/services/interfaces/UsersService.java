package ru.shadrag.hw12.services.interfaces;

import ru.shadrag.hw12.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    void deleteUser(Long id);
}
