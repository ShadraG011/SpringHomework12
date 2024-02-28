package ru.shadrag.hw12.models;

import jakarta.persistence.*;
import lombok.Data;
import ru.shadrag.hw12.components.Priority;
import ru.shadrag.hw12.components.Status;

import java.util.Date;


/**
 * ID (автоинкрементное)
 * Описание (не может быть пустым)
 * Статус (одно из значений: "не начата", "в процессе", "завершена")
 * Дата создания (автоматически устанавливается при создании задачи)
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {

    //region КОНСТРУКТОРЫ
    public Task() {
        this.status = Status.NOT_START;
        this.date = new Date();
    }
    //endregion

    public String getUsername() {
        if (user == null)
            return "Не назначен";
        else
            return user.getUsername();
    }

    //region ПОЛЯ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status")
    private Status status;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    //endregion
}
