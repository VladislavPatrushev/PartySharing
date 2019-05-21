package ru.nsu.bd.partysharing.network.exchange;

import ru.nsu.bd.partysharing.types.InterestType;

import java.io.Serializable;
import java.util.List;

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

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public InterestType getCategory() {
        return category;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public List<Long> getAttend() {
        return attend;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(InterestType category) {
        this.category = category;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public void setAttend(List<Long> attend) {
        this.attend = attend;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
