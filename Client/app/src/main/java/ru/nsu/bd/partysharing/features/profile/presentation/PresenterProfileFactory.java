package ru.nsu.bd.partysharing.features.profile.presentation;

import android.content.Context;

import ru.nsu.bd.partysharing.App;
import ru.nsu.bd.partysharing.features.profile.data.ProfileApi;
import ru.nsu.bd.partysharing.features.profile.data.ProfileDataSource;
import ru.nsu.bd.partysharing.features.profile.data.ProfileDataSourceImp;
import ru.nsu.bd.partysharing.features.profile.domain.ProfileInteractor;
import ru.nsu.bd.partysharing.features.profile.domain.ProfileInteractorImpl;

final public class PresenterProfileFactory {
    static ProfilePresenter createProfilePresenter(Context context) {
        final ProfileApi  profileApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ProfileApi.class);
        final ProfileDataSource dataSource = new ProfileDataSourceImp(profileApi);
        final ProfileInteractor profileInteractor = new ProfileInteractorImpl(dataSource);

        return new ProfilePresenter(profileInteractor);
    }

}
