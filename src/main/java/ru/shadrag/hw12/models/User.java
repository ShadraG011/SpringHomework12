package ru.shadrag.hw12.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "users")
public class User {

    //region КОНСТРУКТОРЫ
    public User() {
    }

    public User(String username) {
        this.username = username;
    }
    //endregion

    //region ПОЛЯ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Task> userTasksList;
    //endregion
}
