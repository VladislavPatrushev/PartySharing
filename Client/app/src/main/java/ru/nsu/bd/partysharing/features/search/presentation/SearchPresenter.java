package ru.nsu.bd.partysharing.features.search.presentation;

import ru.nsu.bd.partysharing.features.MvpPresenter;
import ru.nsu.bd.partysharing.features.search.domain.SearchInteractor;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public class SearchPresenter extends MvpPresenter<SearchActivityView> {
    private final SearchInteractor interactor;

    SearchPresenter(SearchInteractor interactor) {
        this.interactor = interactor;
    }

    public void loadSearch(Long id) {
        interactor.loadSearch(id, new Carry<GetAllEventsResponse>() {

            @Override
            public void onSuccess(GetAllEventsResponse result) {
                view.showEventList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }

        });
    }

    public void editTextSearch(GetAllEventsResponse mLoadedSearchList, String s) {
        interactor.findEventByName(mLoadedSearchList, s);
        interactor.findEventByCategory(mLoadedSearchList, s);
    }
}
