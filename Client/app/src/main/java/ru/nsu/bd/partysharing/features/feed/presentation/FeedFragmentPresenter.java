package ru.nsu.bd.partysharing.features.feed.presentation;

import ru.nsu.bd.partysharing.ImageCache;
import ru.nsu.bd.partysharing.features.MvpPresenter;
import ru.nsu.bd.partysharing.features.feed.domain.FeedInteractor;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.EventPreview;
import ru.nsu.bd.partysharing.network.exchange.FeedResponse;

import java.util.List;


public class FeedFragmentPresenter extends MvpPresenter<FeedView> {

    private final FeedInteractor interactor;

    FeedFragmentPresenter(FeedInteractor interactor) {
        this.interactor = interactor;
    }

    void loadFeed(Long id){
        interactor.loadFeed(id ,new Carry<FeedResponse>() {

            @Override
            public void onSuccess(FeedResponse result) {
                List<EventPreview> previewList = result.getFeed().getData();
                for (EventPreview eventPreview : previewList) {
                    eventPreview.setPreview(ImageCache.getEventImage(eventPreview.getId()));
                }
                List<EventPreview> pendingList = result.getPending().getData();
                for (EventPreview eventPreview : pendingList) {
                    eventPreview.setPreview(ImageCache.getEventImage(eventPreview.getId()));
                }
                view.showEventList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }

        });
    }
}
