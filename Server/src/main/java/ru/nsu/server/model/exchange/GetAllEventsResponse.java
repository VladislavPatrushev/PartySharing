package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetAllEventsResponse implements Serializable {
    /**
     * число записей
     */
    int count;

    /**
     * все мероприятия
     */
    List<EventPreview> events;
}
