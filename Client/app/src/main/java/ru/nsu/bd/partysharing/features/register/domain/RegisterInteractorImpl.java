package ru.nsu.bd.partysharing.features.register.domain;

import ru.nsu.bd.partysharing.network.exchange.RegisterRequest;
import ru.nsu.bd.partysharing.features.register.data.RegisterDataSource;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.RegisterResponse;

public class RegisterInteractorImpl implements RegisterInteractor{

    RegisterDataSource registerDataSource;

    public RegisterInteractorImpl(RegisterDataSource registerDataSource) {
        this.registerDataSource = registerDataSource;
    }

    @Override
    public void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry) {
        registerDataSource.register(registerRequest, carry);
    }
}
