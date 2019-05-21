package ru.nsu.bd.partysharing.features.feed.presentation;

import ru.nsu.bd.partysharing.features.MvpPresenter;
import ru.nsu.bd.partysharing.features.feed.domain.FeedInteractor;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

/**
 * пресентер просто загружает данные, тут даже делать ничего не пришлось пока
 */


public class FeedPresenter extends MvpPresenter<FeedView> {

    private final FeedInteractor interactor;

    FeedPresenter(FeedInteractor interactor) {
        this.interactor = interactor;
    }

    void loadFeed(Long id){
        interactor.loadFeed(id, new Carry<FeedResponse>() {

            @Override
            public void onSuccess(FeedResponse result) {
                view.showEventList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }

        });
    }
}
