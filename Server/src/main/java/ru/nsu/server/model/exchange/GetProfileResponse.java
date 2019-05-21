package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetProfileResponse implements Serializable {
    /**
     * имя
     */
    private String firstName;
    /**
     * фамилия
     */
    private String lastName;
    /**
     * возраст
     */
    private int age;
    /**
     * город
     */
    private String location;
    /**
     * интересы
     */
    private String interests;
    /**
     * мероприятия, в которых участвует
     */
    private List<Long> attend;
    /**
     * мероприятия, которые создал
     */
    private List<Long> manage;
    /**
     * картинка в base64
     */
    private String image;
}
