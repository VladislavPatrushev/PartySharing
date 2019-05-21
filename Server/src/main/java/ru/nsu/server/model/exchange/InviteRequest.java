package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class InviteRequest implements Serializable {
    /**
     * кого приглашаем
     */
    private Long userId;
    /**
     * куда приглашаем
     */
    private Long eventId;
}
