package ru.nsu.bd.partysharing.features.profile.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

public class ProfileDataSourceImp implements ProfileDataSource {
    private final ProfileApi profileApi;

    public ProfileDataSourceImp(ProfileApi profileApi) {
        this.profileApi = profileApi;
    }
    @Override
    public void getProfile(final Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest) {
         profileApi.getProfile(getProfileRequest).enqueue(new DefaultCallback<GetProfileResponse>(carry));
    }
    @Override
    public void getEventsList(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest) {
        profileApi.getEventList(getEventsListRequest).enqueue(new DefaultCallback<GetEventsListResponse>(carry));
    }
}