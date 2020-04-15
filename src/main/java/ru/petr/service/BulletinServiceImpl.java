package ru.petr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petr.dao.BulletinDao;
import ru.petr.entity.Bulletin;
import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {
    @Autowired
    private BulletinDao bulletinDao;

    @Override
    @Transactional
    public List<Bulletin> getBulletins() {
        return bulletinDao.findAll();
    }

    @Override
    @Transactional
    public Bulletin getBulletin(int bulletinId) {
        return bulletinDao.findBYId(bulletinId);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bulletinDao.delete(id);
    }

    @Override
    @Transactional
    public void saveBulletin(Bulletin bulletin) {
        bulletinDao.save(bulletin);
    }

    @Override
    @Transactional
    public List<Bulletin> findByCriteria(String criteria) {
        return bulletinDao.findByCriteria(criteria);
    }
}
