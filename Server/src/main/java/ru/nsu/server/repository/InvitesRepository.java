package ru.nsu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.server.model.Invite;

import java.util.List;

/**
 * Репозиторий для таблицы инвайтов
 */
@Repository
public interface InvitesRepository extends JpaRepository<Invite, Long> {
    /**
     * получить все события на которые приглашен участвует профиль
     * @param profileId
     * @return
     */
    List<Invite> findAllByProfileId(Long profileId);

    /**
     * удалить приглашение по id профиля и эвента
     * @param profileId
     * @param eventId
     */
    @Transactional
    void deleteByProfileIdAndEventId(Long profileId, Long eventId);
}
