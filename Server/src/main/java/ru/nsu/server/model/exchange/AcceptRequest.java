package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class AcceptRequest implements Serializable {
    /**
     * id куда принимаем заявку
     */
    private Long eventId;
    /**
     * от кого принимаем заявку
     */
    private Long userId;
}
