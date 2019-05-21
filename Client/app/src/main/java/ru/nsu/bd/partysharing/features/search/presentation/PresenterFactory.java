package ru.nsu.bd.partysharing.features.search.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;
import ru.nsu.bd.partysharing.features.search.data.SearchDataSource;
import ru.nsu.bd.partysharing.features.search.data.SearchDataSourceImpl;
import ru.nsu.bd.partysharing.features.search.domain.SearchInteractor;
import ru.nsu.bd.partysharing.features.search.domain.SearchInteractorImpl;
import ru.nsu.bd.partysharing.network.ServerAPI;

final class PresenterFactory {

    static SearchPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final SearchDataSource dataSource = new SearchDataSourceImpl(api);
        final SearchInteractor interactor = new SearchInteractorImpl(dataSource);

        return new SearchPresenter(interactor);
    }

}
