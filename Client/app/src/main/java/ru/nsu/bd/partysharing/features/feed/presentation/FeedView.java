package ru.nsu.bd.partysharing.features.feed.presentation;

import ru.nsu.bd.partysharing.features.MvpView;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;


public interface FeedView extends MvpView {

    //void showProgress();

    //void hideProgress();

    void showEventList(FeedResponse list);

    void showError(String message);
}
