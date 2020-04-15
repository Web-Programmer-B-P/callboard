package ru.petr.service;

import ru.petr.entity.Bulletin;
import java.util.List;

public interface BulletinService {
    List<Bulletin> getBulletins();

    Bulletin getBulletin(int bulletinId);

    void delete(int id);

    void saveBulletin(Bulletin bulletin);

    List<Bulletin> findByCriteria(String criteria);
}
