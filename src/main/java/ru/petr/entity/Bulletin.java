package ru.petr.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.StringJoiner;

@Entity
@Table(name = "items")
public class Bulletin {
    private static final String NOT_NULL_NAME = "Название обязательно!";
    private static final String MESSAGE_NAME = "Название может содержать минимум 10 и не более 100 символов!";
    private static final String NOT_NULL_DESCRIPTION = "Заполните описание!";
    private static final String NOT_NULL_PRICE = "Цена не может быть пустое поле!";
    private static final String PRICE_MESSAGE = "Цена должна быть больше 0!";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = NOT_NULL_NAME)
    @Size(min = 10, max = 100, message = MESSAGE_NAME)
    @Column(name = "name")
    private String name;

    @NotNull(message = NOT_NULL_DESCRIPTION)
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NotNull(message = NOT_NULL_PRICE)
    @Min(value = 2, message = PRICE_MESSAGE)
    private Double price;

    @Column(name = "user_id")
    private int userId;

    public Bulletin() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bulletin.class.getSimpleName() + "{", "}")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("price=" + price)
                .add("userId=" + userId)
                .toString();
    }
}
