package ru.nsu.bd.partysharing.features.event.domain;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;

public interface EventInteractor  {
    void loadEvent(Carry<GetEventResponse> carry, GetEventRequest getEventRequest);
    void loadParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest);
}
