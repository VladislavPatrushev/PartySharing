package ru.nsu.server.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RegisterResponse implements Serializable {
    /**
     * id нового пользователя
     */
    private Long id;
}
