package ru.nsu.server.model.exchange;

import lombok.Data;
import ru.nsu.server.model.Profile;

import java.io.Serializable;
import java.util.List;

@Data
public class GetProfilesResponse implements Serializable {
    /**
     * число профилей
     */
    private int count;
    /**
     * профили
     */
    private List<GetProfileResponse> profiles;
}
