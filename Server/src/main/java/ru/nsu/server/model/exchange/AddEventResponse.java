package ru.nsu.server.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class AddEventResponse implements Serializable {
    /**
     * id мероприятия
     */
    Long id;
}
