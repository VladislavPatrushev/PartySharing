package ru.nsu.bd.partysharing.features.profile.presentation;

import android.graphics.Bitmap;

import ru.nsu.bd.partysharing.features.MvpPresenter;
import ru.nsu.bd.partysharing.features.profile.domain.model.Profile;
import ru.nsu.bd.partysharing.features.profile.domain.ProfileInteractor;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListRequest;
import ru.nsu.bd.partysharing.network.exchange.GetEventsListResponse;
import ru.nsu.bd.partysharing.network.exchange.GetProfileRequest;
import ru.nsu.bd.partysharing.network.exchange.GetProfileResponse;
import ru.nsu.bd.partysharing.util.Converter;

import java.util.ArrayList;
import java.util.Arrays;


public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final ProfileInteractor profileInteractor;

    ProfilePresenter(ProfileInteractor profileInteractor) {
        this.profileInteractor=profileInteractor;
    }

    protected void onViewMyProfile(Long id){
        getProfile(id);
    }

    //Показывает профиль на экране
    private void getProfile (Long id) {
        //Нужно где то брать(тоесть где-то в шаред преференс хранится) инфу о проифиле
        GetProfileRequest myProfile=new GetProfileRequest(id);
        profileInteractor.loadProfile(new Carry<GetProfileResponse>() {
            @Override
            public void onSuccess(GetProfileResponse result) {
                ArrayList<String> interests = new ArrayList<>();
                String[] strings = result.getInterests().split(",");
                interests = new ArrayList<>(Arrays.asList(strings));
                Bitmap image = Converter.base64ToBitmap(result.getImage());
                final Profile profile = new Profile(result.getFirstName(),result.getLastName(),result.getAge(),result.getLocation(),interests,image,(ArrayList<Long>) result.getAttend(),(ArrayList<Long>) result.getManage());
                view.showProfile(profile);
            }
            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Problems with profile!");
            }
        },myProfile);
    }
    public void  getAttendEventPreviews(final Profile myProfile) {
        GetEventsListRequest getEventsListRequest = new GetEventsListRequest(myProfile.getAttend());
        profileInteractor.loadAttendEvents(new Carry<GetEventsListResponse>() {
            @Override
            public void onSuccess(GetEventsListResponse result) {
                view.showAttendEventsPreviw(result.getCount(),result.getEvents());
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Problems with eventspreviw");

            }
        },getEventsListRequest);
    }

    public void  getManageEventPreviews(final Profile myProfile) {
        GetEventsListRequest getEventsListRequest = new GetEventsListRequest(myProfile.getManage());
        profileInteractor.loadManageEvents(new Carry<GetEventsListResponse>() {

            @Override
            public void onSuccess(GetEventsListResponse result) {
                view.showManageEventsPreview(result.getCount(),result.getEvents());
            }
            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Problems with eventspreviw");
            }
        },getEventsListRequest);
    }

}
