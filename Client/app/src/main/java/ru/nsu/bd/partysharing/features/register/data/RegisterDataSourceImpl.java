package ru.nsu.bd.partysharing.features.register.data;

import ru.nsu.bd.partysharing.network.exchange.RegisterRequest;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.ServerAPI;
import ru.nsu.bd.partysharing.network.exchange.RegisterResponse;

public class RegisterDataSourceImpl implements RegisterDataSource{

    private final ServerAPI serverAPI;

    public RegisterDataSourceImpl(ServerAPI serverAPI) { this.serverAPI = serverAPI;}


    @Override
    public void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry) {
        serverAPI.postRegistrationInfo(registerRequest).enqueue(new DefaultCallback<>(carry));
    }
}
