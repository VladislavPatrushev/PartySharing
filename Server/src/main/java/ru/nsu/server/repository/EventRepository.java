package ru.nsu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.server.model.Event;
import ru.nsu.server.model.types.InterestType;

import java.util.List;

/**
 * Репозиторий для таблицы событий
 */
@Repository // сообщаем тип энтити и тип id для энтити (почти всегда Long). Это все.
public interface EventRepository extends JpaRepository<Event, Long> {
    /**
     * найти события, входящие хотя бы в одну из заданных категорий
     * @param categories
     * @return
     */
    List<Event> findByCategoryIn(List<InterestType> categories);

    /**
     * получить эвенты, созданные creatorId
     * @param creatorId
     * @return
     */
    List<Event> findAllByCreatorId(Long creatorId);
}
