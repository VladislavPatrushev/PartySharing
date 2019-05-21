package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventPreview implements Serializable {
    /**
     * Event id
     */
    private Long id;
    /**
     * Event name
     */
    private String name;
    /**
     * Превью картинки в кодировке base64
     */
    private String preview;
}
