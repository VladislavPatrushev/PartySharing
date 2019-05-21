package ru.nsu.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.server.model.Event;
import ru.nsu.server.model.Invite;
import ru.nsu.server.model.Participant;
import ru.nsu.server.model.Request;
import ru.nsu.server.model.types.InterestType;
import ru.nsu.server.repository.EventRepository;
import ru.nsu.server.repository.InvitesRepository;
import ru.nsu.server.repository.ParticipantsRepository;
import ru.nsu.server.repository.RequestsRepository;
import ru.nsu.server.util.IdGetter;

import java.util.List;
//
/**
 * Сервис для поиска и сохранения событий
 */
@Service
@Slf4j
public class EventService {

private EventRepository eventRepository;
private InvitesRepository invitesRepository;
private ParticipantsRepository participantsRepository;
private RequestsRepository requestsRepository;


@Autowired
public EventService(EventRepository eventRepository, InvitesRepository invitesRepository,
        ParticipantsRepository participantsRepository, RequestsRepository requestsRepository) {
        this.eventRepository = eventRepository;
        this.invitesRepository = invitesRepository;
        this.participantsRepository = participantsRepository;
        this.requestsRepository = requestsRepository;
        }

/**
 * Получения события по данному id
 *
 * @param eventId id события. Может быть null
 * @return Entity с данным id или null, если ничего не найдено или входной id был null
 */
public Event getEventById(Long eventId) {
        if (eventId == null) {
        log.debug("event Id was null");
        return null;
        }
        // обрабатываем Optional, выдаем null если entity не был найден.
        return eventRepository.findById(eventId).orElse(null);
        }

/**
 * найти события, входящие хотя бы в одну из заданных категорий
 * @param categories
 * @return
 */
public List<Event> getEventsByCategories(List<InterestType> categories) {
        if (categories == null) {
        log.debug("categories was null");
        return null;
        }
        return eventRepository.findByCategoryIn(categories);
        }

public List<Event> getPendingEvents(Long profileId) {
        if (profileId == null) {
        log.debug("Profile id is null");
        return null;
        }
        return eventRepository.
        findAllById(IdGetter.getEventIdsFromInvites(invitesRepository.findAllByProfileId(profileId)));
        }

public List<Event> getRequestedEvents(Long profileId) {
        if (profileId == null) {
        log.debug("Profile id is null");
        return null;
        }
        return eventRepository.
        findAllById(IdGetter.getEventIdsfromRequests(requestsRepository.findAllByProfileId(profileId)));
        }

public List<Long> getAttendEventsIds(Long profileId) {
        if (profileId == null) {
        log.debug("Profile id is null");
        return null;
        }
        return IdGetter.getEventIdsFromEvents(
        eventRepository.
        findAllById(IdGetter.getEventIdsFromPatricipants(participantsRepository.findAllByProfileId(profileId))));
        }

public List<Long> getAttendProfileIds(Long eventId) {
        if (eventId == null) {
        log.debug("Event id is null");
        return null;
        }
        return IdGetter.getProfileIdsFromParticipants(participantsRepository.findAllByEventId(eventId));
        }

public Event saveEvent(Event event) {
        if (event == null) {
        log.debug("Event was null");
        return null;
        }
        return eventRepository.save(event);
        }

public Invite saveInvite(Invite invite) {
        if (invite == null) {
        log.debug("Invite was null");
        return null;
        }
        return invitesRepository.save(invite);
        }

public Request saveRequest(Request request) {
        if (request == null) {
        log.debug("Request was null");
        return null;
        }
        return requestsRepository.save(request);
        }

public Participant saveParticipant(Participant participant) {
        if (participant == null) {
        log.debug("Participant was null");
        return null;
        }
        return participantsRepository.save(participant);
        }

public void deleteRequestByUserAndEventId(Long userId, Long eventId) {
        if (userId == null || eventId == null) {
        log.debug("UserId or eventId was null");
        return;
        }
        requestsRepository.deleteByProfileIdAndEventId(userId, eventId);
        }

public void deleteInviteByUserAndEventId(Long userId, Long eventId) {
        if (userId == null || eventId == null) {
        log.debug("UserId or eventId was null");
        return;
        }
        invitesRepository.deleteByProfileIdAndEventId(userId, eventId);
        }

public List<Long> findEventIdsByCreatorId(Long creatorId) {
        if (creatorId == null) {
        log.debug("CreatorId was null");
        return null;
        }
        return IdGetter.getEventIdsFromEvents(eventRepository.findAllByCreatorId(creatorId));
        }

public void deleteInviteById(Long inviteId) {
        if (inviteId == null) {
        log.debug("InviteId was null");
        return;
        }
        invitesRepository.deleteById(inviteId);
        }

public List<Event> getEventsByIds(List<Long> ids) {
        if (ids == null) {
        log.debug("Events was null");
        return null;
        }
        return eventRepository.findAllById(ids);
        }

public List<Event> getAllEvents() {
        return eventRepository.findAll();
        }

        }
