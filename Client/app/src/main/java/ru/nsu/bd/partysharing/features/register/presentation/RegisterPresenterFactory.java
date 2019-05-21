package ru.nsu.bd.partysharing.features.register.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;

import ru.nsu.bd.partysharing.features.register.data.RegisterDataSource;
import ru.nsu.bd.partysharing.features.register.data.RegisterDataSourceImpl;
import ru.nsu.bd.partysharing.features.register.domain.RegisterInteractor;
import ru.nsu.bd.partysharing.features.register.domain.RegisterInteractorImpl;
import ru.nsu.bd.partysharing.network.ServerAPI;

public class RegisterPresenterFactory {

    static RegisterPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final RegisterDataSource dataSource = new RegisterDataSourceImpl(api);
        final RegisterInteractor interactor = new RegisterInteractorImpl(dataSource);
        return new RegisterPresenter(interactor);
    }

}
