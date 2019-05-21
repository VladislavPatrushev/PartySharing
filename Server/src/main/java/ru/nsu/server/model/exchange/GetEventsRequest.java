package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetEventsRequest implements Serializable {

    private List<Long> ids;
}
