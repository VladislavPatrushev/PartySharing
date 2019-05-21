package ru.nsu.server.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.nsu.server.model.Event;
import ru.nsu.server.model.Profile;
import ru.nsu.server.model.exchange.AddEventRequest;
import ru.nsu.server.model.exchange.EventPreview;
import ru.nsu.server.model.exchange.GetEventResponse;
import ru.nsu.server.model.exchange.GetProfileResponse;
import ru.nsu.server.model.exchange.RegisterRequest;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MyMapper {

    @Mapping(target = "lastName", source = "lastName")
    Profile registerRequestToProfile(RegisterRequest request);

    @Mapping(target = "id", source = "eventId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "preview", source = "image")
    EventPreview eventToEventPreview(Event event);

    @Mapping(target = "attend", source = "attend")
    @Mapping(target = "manage", source = "manage")
    GetProfileResponse profileToGetProfileResponse(Profile profile, List<Long> attend, List<Long> manage);

    @Mapping(target = "creatorId", source = "creatorId")
    Event addEventRequestToEvent(AddEventRequest request, Long creatorId);

    @Mapping(target = "attend", source = "attend")
    GetEventResponse eventToGetEventResponse(Event event, List<Long> attend);
}
