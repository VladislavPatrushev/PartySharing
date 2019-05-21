package ru.nsu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.server.model.Profile;

/**
 * Репозиторий для таблицы профилей
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}