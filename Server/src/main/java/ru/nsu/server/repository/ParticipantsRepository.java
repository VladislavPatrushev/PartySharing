package ru.nsu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.server.model.Participant;
import ru.nsu.server.model.Request;

import java.util.List;

/**
 * Репозиторий для таблицы участников события
 */
@Repository
public interface ParticipantsRepository extends JpaRepository<Participant, Long> {
    /**
     * найти записи в коорых участвует профиль
     * @param profileId
     * @return
     */
    List<Participant> findAllByProfileId(Long profileId);

    /**
     * найти запси, соответствующие данному эвенту
     * @param eventId
     * @return
     */
    List<Participant> findAllByEventId(Long eventId);
}