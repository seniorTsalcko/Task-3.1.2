package ru.kata.academy.Springboot.dao;


import ru.kata.academy.Springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updatedUser);

    User getUserById(int id);

    void deleteUser(int id);
}