package ru.nsu.server.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.server.model.Profile;
import ru.nsu.server.repository.ProfileRepository;

import java.util.List;

/**
 * Сервис для поиска и сохранения событий
 */
@Service
@Slf4j
public class ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /**
     * Получения профиля по данному id
     *
     * @param profileId id профиля. Может быть null
     * @return Entity с данным id или null, если ничего не найдено или входной id был null
     */
    public Profile getProfileById(Long profileId) {
        if (profileId == null) {
            log.debug("profile Id was null");
            return null;
        }
        // обрабатываем Optional, выдаем null если entity не был найден.
        return profileRepository.findById(profileId).orElse(null);
    }

    public List<Profile> getProfilesByIds(List<Long> ids) {
        if (ids == null) {
            log.debug("Ids was null");
            return null;
        }
        return profileRepository.findAllById(ids);
    }

    /**
     * Сохранения профиля в базе данных с присвоением ему id
     *
     * @param profile профиль для сохранения
     * @return входной профиль с проставленным id
     */
    public Profile saveProfile(Profile profile) {
        if (profile == null) {
            log.debug("profile was null");
            return null;
        }
        return profileRepository.save(profile);
    }

//    public void createNewProfile()

}
