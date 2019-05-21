package ru.nsu.bd.partysharing.features.search.presentation;

import ru.nsu.bd.partysharing.features.MvpView;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchActivityView extends MvpView {

    //void showProgress();

    //void hideProgress();

    void showEventList(GetAllEventsResponse list);

    void showError(String message);
}