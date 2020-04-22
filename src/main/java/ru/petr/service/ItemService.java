package ru.petr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petr.dao.ItemDao;
import ru.petr.entity.Item;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<Item> getItems() {
        return itemDao.findAll();
    }

    public Item findById(int itemId) {
        return itemDao.findById(itemId);
    }

    public void delete(int id) {
        itemDao.delete(id);
    }

    public void save(Item item) {
        itemDao.save(item);
    }

    public void update(Item item) {
        itemDao.update(item);
    }

    public List<Item> findByCriteria(String criteria) {
        return itemDao.findByCriteria(criteria);
    }
}
