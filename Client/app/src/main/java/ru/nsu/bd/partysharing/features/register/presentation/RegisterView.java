package ru.nsu.bd.partysharing.features.register.presentation;

import ru.nsu.bd.partysharing.features.MvpView;

public interface RegisterView extends MvpView {
    void showError(String error);
}
