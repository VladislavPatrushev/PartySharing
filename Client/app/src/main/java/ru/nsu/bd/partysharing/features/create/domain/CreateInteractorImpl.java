package ru.nsu.bd.partysharing.features.create.domain;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.ServerAPI;
import ru.nsu.bd.partysharing.network.exchange.AddEventRequest;
import ru.nsu.bd.partysharing.network.exchange.AddEventResponse;

public class CreateInteractorImpl implements CreateInteractor {

    ServerAPI serverAPI;

    public CreateInteractorImpl(ServerAPI serverAPI) {
        this.serverAPI = serverAPI;
    }

    @Override
    public void create(Long id, AddEventRequest request, Carry<AddEventResponse> carry) {
        serverAPI.addEventRequest(id, request).enqueue(new DefaultCallback<>(carry));
    }

}
