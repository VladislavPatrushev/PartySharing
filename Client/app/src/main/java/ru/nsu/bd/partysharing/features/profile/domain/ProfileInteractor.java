package ru.nsu.bd.partysharing.features.profile.domain;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

public interface ProfileInteractor {
    void loadProfile(Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest);
    void loadAttendEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest);
    void loadManageEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest);
}
