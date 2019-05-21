package ru.nsu.server.util;

import ru.nsu.server.model.Event;
import ru.nsu.server.model.Invite;
import ru.nsu.server.model.Participant;
import ru.nsu.server.model.Request;

import java.util.List;
import java.util.stream.Collectors;

//Получить лист id

public class IdGetter {
    public static List<Long> getEventIdsFromInvites(List<Invite> invites) {
        return invites.stream().map(Invite::getEventId)
                .collect(Collectors.toList());
    }

    public static List<Long> getEventIdsfromRequests(List<Request> requests) {
        return requests.stream().map(Request::getEventId)
                .collect(Collectors.toList());
    }

    public static List<Long> getEventIdsFromPatricipants(List<Participant> participants) {
        return participants.stream().map(Participant::getEventId)
                .collect(Collectors.toList());
    }

    public static List<Long> getEventIdsFromEvents(List<Event> events) {
        return events.stream().map(Event::getEventId)
                .collect(Collectors.toList());
    }

    public static List<Long> getProfileIdsFromParticipants(List<Participant> participants) {
        return participants.stream().map(Participant::getProfileId)
                .collect(Collectors.toList());
    }
}
