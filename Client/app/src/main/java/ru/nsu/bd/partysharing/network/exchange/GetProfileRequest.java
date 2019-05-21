package ru.nsu.bd.partysharing.network.exchange;



import java.io.Serializable;
public class GetProfileRequest implements Serializable {
    /**
     * id профиля
     */
    private Long id;

    public GetProfileRequest(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
