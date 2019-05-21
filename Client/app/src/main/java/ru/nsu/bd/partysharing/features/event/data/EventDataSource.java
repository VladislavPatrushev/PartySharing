package ru.nsu.bd.partysharing.features.event.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;

public interface EventDataSource {
    void getEvent(Carry<GetEventResponse> carry,GetEventRequest eventRequest);
    void getParticipants(Carry<GetProfilesResponse> carry,GetProfilesRequest getProfilesRequest);
}
