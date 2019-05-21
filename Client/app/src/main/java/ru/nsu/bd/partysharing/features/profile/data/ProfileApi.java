package ru.nsu.bd.partysharing.features.profile.data;

import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileApi {
    @GET("/profile")
    Call<GetProfileResponse> getProfile(@Body GetProfileRequest getProfileRequest);

    @GET("/events")
    Call<GetAllEventsResponse> getAllEventList();

    @GET("/events")
    Call<GetEventsListResponse> getEventList(@Body GetEventsListRequest getEventsListRequest);

}
