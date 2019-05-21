package ru.nsu.bd.partysharing.features.event.data;

import ru.nsu.bd.partysharing.network.exchange.GetEventRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfilesResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface EventsApi {
    @GET("/event")
    Call<GetEventResponse> getEvent(@Body GetEventRequest getEventRequest);

    @GET("/profiles")
    Call<GetProfilesResponse> getProfiles(@Body GetProfilesRequest getProfilesRequest);
}
