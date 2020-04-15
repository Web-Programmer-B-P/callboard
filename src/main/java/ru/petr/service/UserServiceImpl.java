package ru.petr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petr.dao.UserDao;
import ru.petr.entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User findByEmailAndPassword(User user) {
        return userDao.findByEmailAndPassword(user);
    }
}
