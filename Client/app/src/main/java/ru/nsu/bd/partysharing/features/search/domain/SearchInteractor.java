package ru.nsu.bd.partysharing.features.search.domain;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchInteractor {
    void loadSearch(Long id, Carry<GetAllEventsResponse> carry);

    void findEventByName(GetAllEventsResponse mLoadedSearchList, String s);

    void findEventByCategory(GetAllEventsResponse mLoadedSearchList, String s);
}
