package ru.nsu.server;

import ru.nsu.server.model.Profile;

public class TestHelper {

    public static Profile getFilledProfile() {
        Profile profile = new Profile();
        profile.setAge(1);
        profile.setFirstName("Test");
        profile.setLastName("Test");
        profile.setImage("c===3");
        return profile;
    }
}
