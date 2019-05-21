package ru.nsu.bd.partysharing.network.exchange;
import java.io.Serializable;

public class GetEventRequest implements Serializable {
    /**
     * id эвента
     */
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
