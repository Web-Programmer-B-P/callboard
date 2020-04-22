package ru.petr.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.StringJoiner;

public class Item {
    private static final String NOT_NULL_NAME = "Название обязательно!";
    private static final String MESSAGE_NAME = "Название может содержать минимум 10 и не более 100 символов!";
    private static final String NOT_NULL_DESCRIPTION = "Заполните описание!";
    private static final String NOT_NULL_PRICE = "Цена не может быть пустое поле!";
    private static final String PRICE_MESSAGE = "Цена должна быть больше 0!";
    private int id;

    @NotNull(message = NOT_NULL_NAME)
    @Size(min = 10, max = 100, message = MESSAGE_NAME)
    private String name;

    @NotNull(message = NOT_NULL_DESCRIPTION)
    private String description;

    @NotNull(message = NOT_NULL_PRICE)
    @Min(value = 2, message = PRICE_MESSAGE)
    private Long price;

    private String userName;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "{", "}")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("price=" + price)
                .add("userName='" + userName + "'")
                .toString();
    }
}
