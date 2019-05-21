package ru.nsu.bd.partysharing.features.feed.domain;



import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

public interface FeedInteractor {

    void loadFeed(Long id, Carry<FeedResponse> carry);
}
