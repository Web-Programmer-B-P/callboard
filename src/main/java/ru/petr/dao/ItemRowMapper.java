package ru.petr.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.petr.entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getInt("id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getLong("price"));
        item.setUserName(resultSet.getString("user_name"));
        return item;
    }
}
