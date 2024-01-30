package ru.kata.academy.Springboot.service;


import jakarta.validation.Valid;
import ru.kata.academy.Springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(@Valid User updatedUser);

    User getUserById(int id);

    void deleteUser(int id);
}