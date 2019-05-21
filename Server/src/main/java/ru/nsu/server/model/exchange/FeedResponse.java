package ru.nsu.server.model.exchange;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FeedResponse implements Serializable {

    @Data
    public static class Pending  implements Serializable {
        /**
         * число уведомлений
         */
        private int count;
        /**
         * превью уведомлений
         */
        private List<EventPreview> data;
    }

    @Data
    public static class Feed implements Serializable {
        /**
         * число событий в ленте
         */
        private int count;
        /**
         * Превью событий в ленте
         */
        private List<EventPreview> data;
    }

    /**
     * уведомления
     */
    Pending pending;
    /**
     * лента
     */
    Feed feed;
}
