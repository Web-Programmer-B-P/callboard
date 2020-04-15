package ru.petr.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
public class User {
    private static final String EMAIL_REGEX = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
    private static final String NOT_NULL_EMAIL = "Поле не может быть пустым!";
    private static final String MESSAGE_EMAIL = "Введите корретный Email!";
    private static final String NOT_NULL_PASSWORD = "Введите пароль!";
    private static final String MESSAGE_PASSWORD = "Короткий пароль нужен больше 3 символов!";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotNull(message = NOT_NULL_EMAIL)
    @Pattern(regexp = EMAIL_REGEX, message = MESSAGE_EMAIL)
    private String email;

    @NotNull(message = NOT_NULL_PASSWORD)
    @Column(name = "password")
    @Size(min = 4, max = 30, message = MESSAGE_PASSWORD)
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "{", "}")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("role='" + role + "'")
                .toString();
    }
}
