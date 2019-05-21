package ru.nsu.bd.partysharing.features.event.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;
import ru.nsu.bd.partysharing.features.event.data.EventDataSource;
import ru.nsu.bd.partysharing.features.event.data.EventDataSourceImpl;
import ru.nsu.bd.partysharing.features.event.data.EventsApi;
import ru.nsu.bd.partysharing.features.event.domain.EventInteractor;
import ru.nsu.bd.partysharing.features.event.domain.EventInteractorImpl;

final public class PresenterEventFactory {
    static EventPresenter createEventPresenter(Context context) {
        final EventsApi eventsApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(EventsApi.class);
        final EventDataSource dataSource = new EventDataSourceImpl(eventsApi);
        final EventInteractor eventInteractor = new EventInteractorImpl(dataSource);
        return new EventPresenter(eventInteractor);
    }
}
