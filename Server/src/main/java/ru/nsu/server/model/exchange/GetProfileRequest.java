package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetProfileRequest implements Serializable {
    /**
     * id профиля
     */
    private Long id;
}
