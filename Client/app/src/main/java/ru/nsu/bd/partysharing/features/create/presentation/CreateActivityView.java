package ru.nsu.bd.partysharing.features.create.presentation;

import ru.nsu.bd.partysharing.features.MvpView;

public interface CreateActivityView extends MvpView {
    //void showProgress();

    //void hideProgress();

    //void showProfile();

    void showError(String message);
}
