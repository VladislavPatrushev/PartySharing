package ru.nsu.bd.partysharing.features.feed.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

public interface FeedDataSource {
    void loadFeed(Long id, Carry<FeedResponse> carry);
}
