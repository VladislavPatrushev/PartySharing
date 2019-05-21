package ru.nsu.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity для таблицы пользователей, подавших заявку на участие в данном Event
 * Содержит event_id (id события) и profile_id (id пользователя в системе)
 */
@Data
@Entity
@Table(name = "requests")
public class Request implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // стратегия генерации ID сущности в БД
    private Long requestId;

    /**
     * Event ID
     */
    @Column(name = "event_id")
    private Long eventId;

    /**
     * Profile ID
     */
    @Column(name = "profile_id")
    private Long profileId;
}
