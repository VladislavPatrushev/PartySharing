package ru.nsu.bd.partysharing.features.event.domain;

import ru.nsu.bd.partysharing.features.event.data.EventDataSource;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;

//Обращаемся к API модели Event
public class EventInteractorImpl implements EventInteractor {
    private final EventDataSource eventDataSource;

    public EventInteractorImpl(EventDataSource eventDataSource) {
        this.eventDataSource = eventDataSource;
    }

    @Override
    public void loadEvent(Carry<GetEventResponse> carry, GetEventRequest getEventRequest) {
        eventDataSource.getEvent(carry,getEventRequest);
    }

    @Override
    public void loadParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest) {
        eventDataSource.getParticipants(carry, getProfilesRequest);
    }
}
