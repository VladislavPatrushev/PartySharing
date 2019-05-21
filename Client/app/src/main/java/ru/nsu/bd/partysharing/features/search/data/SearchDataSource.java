package ru.nsu.bd.partysharing.features.search.data;

import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchDataSource {
    void loadSearch(Long id, Carry<GetAllEventsResponse> carry);
}
