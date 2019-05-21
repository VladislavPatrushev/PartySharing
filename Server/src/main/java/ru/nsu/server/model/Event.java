package ru.nsu.server.model;

import lombok.Data;
import ru.nsu.server.model.types.InterestType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Entity для хранения всех Событий
 */
@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    /**
     * Название события
     */
    @Column(name = "name")
    private String name;

    /**
     * Локация события. Геометка.
     */
    @Column(name = "location")
    private String location;

    /**
     * Локация события. Адресс.
     */
    @Column(name = "address")
    private String address;

    /**
     * Описание события
     */
    @Column(name = "description")
    private String description;

    /**
     * Дата события
     */
    @Column(name = "date")
    private LocalDateTime date;

    /**
     * Категория события
     */
    @Column(name = "category")
    @Enumerated(EnumType.STRING) // указание стратегии сохранения перечисления в БД
    private InterestType category;

    /**
     * Id пользователя, создавшего событие
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * Превьюшка для Event
     */
    @Column(name = "image")
    private String image;
    //TODO разобраться как хранить
//    @Column(name = "image", nullable = false)
//    private List<InterestType> arguments = new ArrayList<>();
}
