package ru.petr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.petr.entity.Item;
import java.util.List;

@Repository
public class ItemDao {
    private final static String SQL_GET_ALL = "SELECT * FROM item";
    private static final String FIND_ITEM = "SELECT * FROM item WHERE id=:id";
    private final static String INSERT_QUERY = "INSERT INTO item (name, description, price, user_name) VALUES (:name, :description, :price, :userName)";
    private final static String UPDATE_QUERY = "UPDATE item SET name=:name, description=:description, price=:price, user_name=:userName WHERE id=:id";
    private final static String DELETE_QUERY = "DELETE FROM item WHERE id=:id";
    private final static String FIND_BY_CRITERIA_QUERY = "SELECT * FROM item WHERE name LIKE :criteria OR description LIKE :criteria";
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Item> findAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new ItemRowMapper());
    }

    public Item findById(int itemId) {
        SqlParameterSource param = new MapSqlParameterSource("id", itemId);
        return namedParameterJdbcTemplate.queryForObject(FIND_ITEM, param, new ItemRowMapper());
    }

    public void save(Item item) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(item);
        namedParameterJdbcTemplate.update(INSERT_QUERY, params);
    }

    public void update(Item item) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(item);
        namedParameterJdbcTemplate.update(UPDATE_QUERY, params);
    }

    public void delete(int id) {
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update(DELETE_QUERY, param);
    }

    public List<Item> findByCriteria(String criteria) {
        SqlParameterSource param = new MapSqlParameterSource("criteria", "%" + criteria + "%");
        return namedParameterJdbcTemplate.query(FIND_BY_CRITERIA_QUERY, param, new ItemRowMapper());
    }
}