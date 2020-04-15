package ru.petr.dao;

import ru.petr.entity.Bulletin;
import java.util.List;

public interface BulletinDao {
    List<Bulletin> findAll();

    Bulletin findBYId(int bulletinId);

    void delete(int bulletinId);

    void save(Bulletin bulletin);

    List<Bulletin> findByCriteria(String criteria);
}
