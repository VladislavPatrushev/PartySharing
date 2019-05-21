package ru.nsu.bd.partysharing.features.create.domain;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.AddEventRequest;
import ru.nsu.bd.partysharing.network.exchange.AddEventResponse;

public interface CreateInteractor {

    public void create(Long id, AddEventRequest request, Carry<AddEventResponse> carry);

}
