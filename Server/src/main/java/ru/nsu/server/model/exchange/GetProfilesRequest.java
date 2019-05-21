package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetProfilesRequest implements Serializable {
    /**
     * айдишники профилей
     */
    private List<Long> ids;
}
