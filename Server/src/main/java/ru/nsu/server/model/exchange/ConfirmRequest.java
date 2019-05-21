package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmRequest implements Serializable {
    /**
     * куда соглашаемся пойти
     */
    private Long eventId;
}
