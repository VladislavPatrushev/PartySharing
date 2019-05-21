package ru.nsu.server.model.types;

/**
 * Типы интересов (увлечений) пользователя
 * Так же связан с таблицей Event
 */
public enum InterestType {
    AUTO("Автомобили"),
    BISNESS("Бизнес"),
    PARTIES("Вечеринки"),
    ART("Искусство"),
    HISTORY("История"),
    IT("IT и технологии"),
    FILMS("Кино"),
    MUSIC("Музыка"),
    SPORT("Спорт"),
    PHOTO("Фото"),
    HUMOR("Юмор");

    private String formattedName;

    InterestType(String formattedName) {
        this.formattedName = formattedName;
    }
}
