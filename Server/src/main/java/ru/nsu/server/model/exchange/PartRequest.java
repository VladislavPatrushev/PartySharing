package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartRequest implements Serializable {
    private Long eventId;
}
