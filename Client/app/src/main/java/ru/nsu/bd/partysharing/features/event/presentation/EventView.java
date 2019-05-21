package ru.nsu.bd.partysharing.features.event.presentation;

import ru.nsu.bd.partysharing.features.MvpView;
import ru.nsu.bd.partysharing.features.event.domain.model.Event;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;

import java.util.List;

public interface EventView extends MvpView {
    void showEvent(Event event);

    void showParticipants(int numPartic, List<GetProfileResponse> profiles);

    void showError(String message);
}
