package ru.petr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.petr.entity.User;
import javax.persistence.NoResultException;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String QUERY_BY_EMAIL_AND_PASSWORD = "from User where email=:email and password=:password";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByEmailAndPassword(User user) {
        Session session = sessionFactory.getCurrentSession();
        User result = null;
        try {
            Query query = session.createQuery(QUERY_BY_EMAIL_AND_PASSWORD);
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            result = (User) query.getSingleResult();
        } catch (NoResultException ignored) {
            //Это нужно тупо для того чтобы вернуть null
        }
        return result;
    }
}
