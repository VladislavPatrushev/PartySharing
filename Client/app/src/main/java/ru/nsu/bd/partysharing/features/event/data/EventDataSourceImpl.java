package ru.nsu.bd.partysharing.features.event.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;

public class EventDataSourceImpl implements EventDataSource{
    private final  EventsApi eventsapi;
    public EventDataSourceImpl(EventsApi eventsApi) {
        this.eventsapi = eventsApi;
    }
    @Override
    public void getEvent(Carry<GetEventResponse> carry, GetEventRequest eventRequest) {
        eventsapi.getEvent(eventRequest).enqueue(new DefaultCallback<GetEventResponse>(carry));
    }
    @Override
    public void getParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest) {
        eventsapi.getProfiles(getProfilesRequest).enqueue(new DefaultCallback<GetProfilesResponse>(carry));

    }
}
