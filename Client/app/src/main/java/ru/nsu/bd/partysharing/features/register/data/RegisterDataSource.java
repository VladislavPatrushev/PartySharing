package ru.nsu.bd.partysharing.features.register.data;

import ru.nsu.bd.partysharing.network.exchange.RegisterRequest;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.RegisterResponse;

public interface RegisterDataSource {

    void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry);

}
