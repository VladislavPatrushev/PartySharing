package ru.nsu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.server.model.Request;

import java.util.List;

/**
 * репозиторий для таблицы запросов на участие
 */
@Repository
public interface RequestsRepository  extends JpaRepository<Request, Long> {
    /**
     * найти запросы на участие для профиля
     * @param profileId
     * @return
     */
    List<Request> findAllByProfileId(Long profileId);


    /**
     * удалить запрос по id профиля и эвента
     * @param profileId
     * @param eventId
     */
    @Transactional
    void deleteByProfileIdAndEventId(Long profileId, Long eventId);
}
