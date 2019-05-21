package ru.nsu.bd.partysharing.features.feed.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.DefaultCallback;
import ru.nsu.bd.partysharing.network.ServerAPI;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

public class FeedDataSourceImpl implements FeedDataSource {

    private final ServerAPI serverAPI;

    public FeedDataSourceImpl(ServerAPI serverAPI) { this.serverAPI = serverAPI;}

    @Override
    public void loadFeed(Long id, Carry<FeedResponse> carry) {
        serverAPI.getFeed(id).enqueue(new DefaultCallback<>(carry));
    }
}
