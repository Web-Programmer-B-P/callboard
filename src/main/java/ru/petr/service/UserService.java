package ru.petr.service;

import ru.petr.entity.User;

public interface UserService {
    User findByEmailAndPassword(User user);
}
