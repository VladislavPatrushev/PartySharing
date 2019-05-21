package ru.nsu.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity для таблицы профилей пользователей
 * При первой регистрации все пользователи попадают в эту таблицу
 * Хранит указанные при регистрации анкетные данные и аватар
 */
@Data
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    /**
     * ID профиля пользователя
     */
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    /**
     * Имя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Возраcт
     */
    @Column(name = "age")
    private Integer age;

    /**
     * город
     */
    @Column(name = "location")
    private String location;

    //TODO разобраться как хранить
    //можно хранить через разделитель
    /**
     * Интересы (через разделитель)
     */
    @Column(name = "interests")
    private String interests;
//    @Column(name = "image", nullable = false)
//    private List<InterestType> arguments = new ArrayList<>();

    //TODO переделать в @Lob, вспомнить какие там проблемы были при хранении стринга
    /**
     * Превью аватарки пользователя
     */
    @Column(name = "image")
    private String image;
}
