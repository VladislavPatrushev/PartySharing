package ru.nsu.bd.partysharing.features.profile.presentation;

import ru.nsu.bd.partysharing.features.MvpView;
import ru.nsu.bd.partysharing.features.profile.domain.model.Profile;
import ru.nsu.bd.partysharing.network.exchange.EventPreview;

import java.util.List;

public interface ProfileView extends MvpView {
    //void showProgress();

    //void hideProgress();
    void showAttendEventsPreviw(int eventsNum, List<EventPreview> eventPreviews);
    void showProfile(Profile profile);
    void showManageEventsPreview(int eventsNum, List<EventPreview> eventPreviews);
    void showError(String message);
}
