package ru.petr.dao;

import ru.petr.entity.User;

public interface UserDao {
    User findByEmailAndPassword(User user);
}
