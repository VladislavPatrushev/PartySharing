package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetEventsResponse implements Serializable {

    private int count;

    private List<EventPreview> events;
}
