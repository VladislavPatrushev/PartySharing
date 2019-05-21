package ru.nsu.bd.partysharing.features.profile.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

public interface ProfileDataSource {

    void getProfile(Carry<GetProfileResponse> carry,GetProfileRequest getProfileRequest);
    void getEventsList(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest);
}
