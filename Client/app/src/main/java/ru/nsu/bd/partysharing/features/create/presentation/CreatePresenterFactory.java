package ru.nsu.bd.partysharing.features.create.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;
import ru.nsu.bd.partysharing.features.create.domain.CreateInteractor;
import ru.nsu.bd.partysharing.features.create.domain.CreateInteractorImpl;

import ru.nsu.bd.partysharing.network.ServerAPI;

class CreatePresenterFactory {
    static CreatePresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        CreateInteractor interactor = new CreateInteractorImpl(api);
        return new CreatePresenter(interactor);
    }
}
