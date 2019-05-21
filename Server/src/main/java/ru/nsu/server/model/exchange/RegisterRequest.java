package ru.nsu.server.model.exchange;


import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Возрат
     */
    private Integer age;
    /**
     * город
     */
    private String location;

    /**
     * Интересы
     */
    private String interests;

    /**
     * Превью аватарки пользователя
     */
    private String image;


}
