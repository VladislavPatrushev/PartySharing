package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetEventRequest implements Serializable {
    /**
     * id эвента
     */
    private Long id;
}
