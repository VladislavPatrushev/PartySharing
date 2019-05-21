package ru.nsu.bd.partysharing.features.event.presentation;

import android.graphics.Bitmap;

import ru.nsu.bd.partysharing.features.MvpPresenter;
import ru.nsu.bd.partysharing.features.event.domain.EventInteractor;
import ru.nsu.bd.partysharing.features.event.domain.model.Event;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;
import ru.nsu.bd.partysharing.util.Converter;

public class EventPresenter extends MvpPresenter<EventView> {
    private final EventInteractor eventInteractor;
    EventPresenter(EventInteractor eventInteractor) {
        this.eventInteractor=eventInteractor;
    }

    protected void onViewMyEvent(){
        getEvent();
    }

    private void getEvent(){
        //Временно поставил getEventRequest = null потом пропишу
        GetEventRequest getEventRequest = null;
        eventInteractor.loadEvent(new Carry<GetEventResponse>() {
            @Override
            public void onSuccess(GetEventResponse result) {
                Bitmap image = Converter.base64ToBitmap(result.getImage());
                Event event = new Event(result.getName(),result.getLocation(),result.getAddress()
                        ,result.getDate(),result.getCategory(),result.getCreatorId(),result.getAttend(),image);
                view.showEvent(event);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Fail in loadEvents!");
            }
        },getEventRequest);
    }

    public void getParticipants(){
        //  getProfilesRequest должен браться из ответа на запрос выше
        GetProfilesRequest getProfilesRequest = null;
        eventInteractor.loadParticipants(new Carry<GetProfilesResponse>() {
            @Override
            public void onSuccess(GetProfilesResponse result) {
                view.showParticipants(result.getCount(),result.getProfiles());
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Fail in getParticuoanst!");

            }
        },getProfilesRequest);
    }
}
