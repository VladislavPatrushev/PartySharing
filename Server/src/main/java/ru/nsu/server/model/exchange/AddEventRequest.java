package ru.nsu.server.model.exchange;

import lombok.Data;
import ru.nsu.server.model.types.InterestType;

import java.io.Serializable;

@Data
public class AddEventRequest implements Serializable {
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
     * картинка в base64
     */
    private String image;
}
