package ru.nsu.bd.partysharing.network.exchange;

import java.io.Serializable;

public class PartRequest implements Serializable {
    private Long eventId;

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }
}
