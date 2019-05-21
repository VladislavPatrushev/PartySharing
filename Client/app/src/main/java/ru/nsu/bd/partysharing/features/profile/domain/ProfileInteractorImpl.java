package ru.nsu.bd.partysharing.features.profile.domain;

import ru.nsu.bd.partysharing.features.profile.data.ProfileDataSource;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

// Обащаемся к API модели Profile
public class ProfileInteractorImpl implements ProfileInteractor {
    private final ProfileDataSource profileBase;

    public ProfileInteractorImpl(ProfileDataSource profileBase) {
        this.profileBase = profileBase;
    }

    @Override
    public void loadProfile(Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest) {
        profileBase.getProfile(carry, getProfileRequest);
    }

    @Override
    public void loadAttendEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest) {

        profileBase.getEventsList(carry, getEventsListRequest);
    }

    @Override
    public void loadManageEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest) {
        profileBase.getEventsList(carry, getEventsListRequest);
    }
}
