package ru.nsu.bd.partysharing.features.feed.domain;

import ru.nsu.bd.partysharing.features.feed.data.FeedDataSource;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

public class FeedInteractorImpl implements FeedInteractor{

    private final FeedDataSource dataSource;

    public FeedInteractorImpl(FeedDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadFeed(Long id, Carry<FeedResponse> carry) {
        dataSource.loadFeed(id, carry);
    }
}
