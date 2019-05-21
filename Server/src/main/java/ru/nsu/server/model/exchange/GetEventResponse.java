package ru.nsu.server.model.exchange;

import lombok.Data;
import ru.nsu.server.model.types.InterestType;

import java.io.Serializable;
import java.util.List;

@Data
public class GetEventResponse implements Serializable {
    private String name;
    /**
     * геометка
     */
    private String location;
    /**
     * адрес (город, улица ...)
     */
    private String address;
    private String description;
    private String date;
    private InterestType category;
    /**
     * id создателя
     */
    private Long creatorId;
    /**
     * id посетителей
     */
    private List<Long> attend;
    /**
     * картинка в base64
     */
    private String image;
}
