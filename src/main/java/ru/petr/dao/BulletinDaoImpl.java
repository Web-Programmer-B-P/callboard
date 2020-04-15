package ru.petr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.petr.entity.Bulletin;
import java.util.List;

@Repository
public class BulletinDaoImpl implements BulletinDao {
    private static final String QUERY_DELETE = "delete from Bulletin where id=:id";
    private static final String QUERY_CRITERIA = "from Bulletin where description like :description or name like :name";
    private static final String QUERY_ALL = "from Bulletin";
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bulletin> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(QUERY_ALL).list();
    }

    @Override
    public Bulletin findBYId(int bulletinId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Bulletin.class, bulletinId);
    }

    @Override
    public void delete(int bulletinId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(QUERY_DELETE);
        query.setParameter("id", bulletinId);
        query.executeUpdate();
    }

    @Override
    public void save(Bulletin bulletin) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(bulletin);
    }

    @Override
    public List<Bulletin> findByCriteria(String criteria) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(QUERY_CRITERIA);
        query.setParameter("description", "%" + criteria + "%");
        query.setParameter("name", "%" + criteria + "%");
        return query.list();
    }
}
