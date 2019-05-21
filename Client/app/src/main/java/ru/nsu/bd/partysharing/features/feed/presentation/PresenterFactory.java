package ru.nsu.bd.partysharing.features.feed.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;
import ru.nsu.bd.partysharing.features.feed.data.FeedDataSource;
import ru.nsu.bd.partysharing.features.feed.data.FeedDataSourceImpl;
import ru.nsu.bd.partysharing.features.feed.domain.FeedInteractor;
import ru.nsu.bd.partysharing.features.feed.domain.FeedInteractorImpl;
import ru.nsu.bd.partysharing.network.ServerAPI;


final class PresenterFactory {

    static FeedPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final FeedDataSource dataSource = new FeedDataSourceImpl(api);
        final FeedInteractor interactor = new FeedInteractorImpl(dataSource);

        return new FeedPresenter(interactor);
    }

}