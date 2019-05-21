package ru.nsu.bd.partysharing.features.search.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.ServerAPI;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public class SearchDataSourceImpl implements SearchDataSource{
    private final ServerAPI serverAPI;

    public SearchDataSourceImpl(ServerAPI serverAPI) {
        this.serverAPI = serverAPI;
    }

    @Override
    public void loadSearch(Long id, Carry<GetAllEventsResponse> carry) {
        serverAPI.getEventList(id).enqueue(new DefaultCallback<>(carry));
    }
}
